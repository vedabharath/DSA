package com.bharath.skills.main;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;

public class NumberOfWays {
/*
    int mod = 1000000007;
    
    private int util(int s, int t, int k, HashMap<Pair<Integer,Integer>,Integer> map){
        
        if(s == t && k == 0) return 1;
        
        if(k <= 0) return 0;

        Pair p = new Pair<Integer,Integer>(s,k);
        if(map.containsKey(p)) return map.get(p);

        int res = (util(s+1,t, k-1,map)%mod + util(s-1,t,k-1,map)%mod)%mod;
        map.put(p,res);
        
        return res;
        
        
        
    }
    public int numberOfWays(int s, int t, int k) {

        HashMap<Pair<Integer,Integer>,Integer> map = new HashMap<>();
        
        return util(s,t,k,map);
        
    }*/

    private int MOD = 1_000_000_007;

    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3001][1001];
        for (int[] row : dp) Arrays.fill(row, -1);
        return numberOfWays(startPos, endPos, k, dp);
    }

    private int numberOfWays(int startPos, int endPos, int k, int[][] dp) {
        if (k <= 0) return startPos == endPos ? 1 : 0;
        if (dp[startPos + 1000][k] != -1) return dp[startPos + 1000][k];
        int steps = 0;
        steps += numberOfWays(startPos - 1, endPos, k - 1,dp) % MOD;
        steps += numberOfWays(startPos + 1, endPos, k - 1,dp) % MOD;
        return dp[startPos + 1000][k] = steps % MOD;
    }

    public static void main(String[] args) {

        NumberOfWays sol = new NumberOfWays();
        System.out.println(sol.numberOfWays(1,2,3));
        System.out.println(sol.numberOfWays(588,706,1000));
    }
}