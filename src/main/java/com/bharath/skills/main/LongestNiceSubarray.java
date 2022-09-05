package com.bharath.skills.main;

public class LongestNiceSubarray {
    
    public int longestNiceSubarray(int[] nums) {
        
        int l=0,r=0,ans = -1,ac=0;
        
        while(r < nums.length){
            
            if((ac & nums[r]) == 0){
                ans = Math.max(r-l+1,ans);
                ac |= nums[r];
                r++;
                
            }else {
                
                ac = ac^nums[l++];
            }
            
            
            
        }
        
        return ans;
        
        
        
    }

    public static void main(String[] args) {

    }
}