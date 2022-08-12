package com.bharath.skills.main;

import java.util.HashMap;

public class ValidPartition {

    public boolean validPartition2(int[] n) {
        boolean[] dp = {true, false, n[0] == n[1], false};
        for (int i = 2; i < n.length; ++i) {
            boolean two = n[i] == n[i - 1];
            boolean three = (two && n[i] == n[i - 2]) || (n[i] - 1 == n[i - 1] && n[i] - 2 == n[i - 2]);
            dp[(i + 1) % 4] = (two && dp[(i - 1) % 4]) || (three && dp[(i - 2) % 4]);
        }
        return dp[n.length % 4];
    }

    public boolean validPartition(int[] a) {
        
        int n = a.length;
        
        boolean[] dp = new boolean[n];
        dp[1] = a[0] == a[1];
        if(n == 2) return dp[1];
        
        dp[2] = (dp[1] && a[1]==a[2]) || (a[1]-a[0] == 1 && a[2] - a[1] == 1);
        
        for(int i=3;i<n;i++){
                
                dp[i] = (a[i-1] == a[i] && dp[i-2]) || 
                    (a[i-2] == a[i-1] && a[i-1] == a[i] && dp[i-3])||
                    (a[i-2]+1 == a[i-1] && a[i-1]+1 == a[i] && dp[i-3]);
        }
        
        return dp[n-1];
        
    }
}