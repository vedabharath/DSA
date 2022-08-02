package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static int[] solve(int n, int[][] B, int s) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: B){
            adj.get(e[0]).add(new int[]{e[1],e[2]});
            adj.get(e[1]).add(new int[]{e[0],e[2]});
        }

        int[]  dist = new int[n];

        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        q.add(new int[]{s,0});

        while(!q.isEmpty()){

            int[] a = q.poll();

            int u = a[0];

            if(dist[u] < a[1]) continue;

            dist[u] = a[1];

            for(int[] edge: adj.get(u)){

                int v = edge[0], w = edge[1];

                if(dist[u]+w < dist[v]){
                    dist[v] = dist[u]+w;
                    q.add(new int[]{v,dist[u]+w});
                }

            }

        }

        return dist;

    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solve(6,new int[][]{{0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1}},4)));

    }
}

