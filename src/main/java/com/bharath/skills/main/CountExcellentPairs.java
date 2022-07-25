package com.bharath.skills.main;

import java.util.HashSet;

class CountExcellentPairs {

    HashSet<String> set = new HashSet<>();

    public long countExcellentPairs(int[] nums, int k) {

        int n = nums.length;
        long ans = 0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                int a = nums[i];
                int b = nums[j];

                if(set.contains(a+""+b)) continue;

                if(Integer.bitCount(a|b)+Integer.bitCount(a&b) >= k){
                    ans++;
                    if(i != j) ans++;
                    set.add(a+""+b);
                    set.add(b+""+a);

                }
            }
        }

        return ans;
        
    }
}