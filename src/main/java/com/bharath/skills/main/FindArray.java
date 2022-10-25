package com.bharath.skills.main;

public class FindArray {
    public int[] findArray(int[] pref) {
        
        int n = pref.length;
        
        int[] ans = new int[n];
        
        ans[0] = pref[0];
        
        int res = pref[0];
        
        for(int i=1;i<n;i++){
            
            ans[i] = res^pref[i];
            res = pref[i];
            
        }
        
        return ans;
        
    }
}