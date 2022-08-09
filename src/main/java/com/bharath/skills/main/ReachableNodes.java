package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.HashSet;

public class ReachableNodes {

    private int dfs(ArrayList<ArrayList<Integer>> adj, int u, HashSet<Integer> r){

        int res = 1;

        r.add(u);

        for(int v : adj.get(u)){
            if(!r.contains(v))
                res += dfs(adj,v,r);

        }

        return res;

    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for(int res: restricted)
            set.add(res);

        return dfs(adj,0,set);

    }

    public static void main(String[] args) {

        /*
        7
        [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]]
        [4,5]
         */
        System.out.println(new ReachableNodes().reachableNodes(7,
                new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}},
                new int[]{4,5}));
    }
}