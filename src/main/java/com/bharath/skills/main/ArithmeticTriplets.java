package com.bharath.skills.main;

import java.util.HashSet;

public class ArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        HashSet<Integer> set = new HashSet<>();
        
        int count = 0;
        
        for(int num: nums){
            if(set.contains(num-diff) && set.contains(num-2*diff)) count++;
            set.add(num);
        }
        
        return count;
    }
}