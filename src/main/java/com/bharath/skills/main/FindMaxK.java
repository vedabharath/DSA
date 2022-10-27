package com.bharath.skills.main;

import java.util.HashSet;

public class FindMaxK {
    public int findMaxK(int[] nums) {
        
        int max = -1;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num: nums){
            
            if(set.contains(-num)) max = Math.max(Math.abs(num),max);
            
            set.add(num);
            
        }
        
        return max;
        
    }
}