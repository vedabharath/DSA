package com.bharath.skills.main;

import java.util.*;
import java.util.LinkedList;

public class BuildMatrix {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

    boolean isPossible = true;
    Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
    int[] indegree = new int[numCourses];
    int[] topologicalOrder = new int[numCourses];

    // Create the adjacency list representation of the graph
    for (int i = 0; i < prerequisites.length; i++) {
      int src = prerequisites[i][0];
      int dest = prerequisites[i][1];
      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
      lst.add(dest);
      adjList.put(src, lst);

      // Record in-degree of each vertex
      indegree[dest-1] += 1;
    }

    // Add all vertices with 0 in-degree to the queue
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.add(i+1);
      }
    }

    int i = 0;
    // Process until the Q becomes empty
    while (!q.isEmpty()) {
      int node = q.remove();
      topologicalOrder[i++] = node;

      // Reduce the in-degree of each neighbor by 1
      if (adjList.containsKey(node)) {
        for (Integer neighbor : adjList.get(node)) {
          indegree[neighbor-1]--;

          // If in-degree of a neighbor becomes 0, add it to the Q
          if (indegree[neighbor-1] == 0) {
            q.add(neighbor);
          }
        }
      }
    }

    // Check to see if topological sort is possible or not.
    if (i == numCourses) {
      return topologicalOrder;
    }

    return new int[0];
  }
    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        int[] row = findOrder(k,rowConditions);
        int[] col = findOrder(k,colConditions);

        if(row.length == 0 || col.length == 0) return new int[0][0];

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< row.length;i++) map.put(row[i],i);

        int[][] res = new int[k][k];

        for(int i=0;i<k;i++)
            res[map.get(col[i])][i] = col[i];

        return res;
    }

    public static void main(String[] args) {

        BuildMatrix sol = new BuildMatrix();

        System.out.println(sol.buildMatrix(3,new int[][]{{1,2},{3,2}},

    new int[][]{{2,1},{3,2}}));

    }
}