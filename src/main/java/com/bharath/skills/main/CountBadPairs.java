package com.bharath.skills.main;

import java.util.HashMap;

public class CountBadPairs {
    public long countBadPairs(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long  good = 0;

        long n = nums.length;

        long total = (n*(n-1))/2;

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i] - i))
                good += map.get(nums[i] - i);
            map.putIfAbsent(nums[i] - i,0);
            map.put(nums[i] - i,map.get(nums[i] - i)+1);
        }

        return total-good;

    }
}