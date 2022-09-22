package com.bharath.skills.main;

public class LongestContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        
        int st=0, en = 1, ans = 0, n = s.length();
        
        while(en<n){
            
            if(s.charAt(en)-s.charAt(en-1) != 1){
                ans = Math.max(ans,en-st);
                st = en;
            }
            
            en++;
     
        }
        
        ans = Math.max(ans,en-st);
        
        return ans;
    }
}