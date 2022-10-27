package com.bharath.skills.main;

public class CountSubarrays {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long ans = 0;
        int n = nums.length;
        
        int start = -1, minKi=-1, maxKi=-1;
        
        for(int i=0;i<n;i++){
            
            if(nums[i] < minK || nums[i] > maxK){
                start = i;
                minKi = i;
                maxKi = i;
                continue;
            }
            
            if(nums[i] == minK) minKi = i;
            if(nums[i] == maxK) maxKi = i;
            
            ans += Math.min(minKi,maxKi)-start;
        }
        
        return ans;
        
    }
}