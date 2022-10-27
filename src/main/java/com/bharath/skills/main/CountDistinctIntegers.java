package com.bharath.skills.main;

import java.util.HashSet;

public class CountDistinctIntegers {
    
    
    public int countDistinctIntegers(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num: nums){
            
            set.add(num);
            
            int a = 0;
            
            while(num > 0){
                a = a*10+num%10;
                num /= 10;
            }
            
            set.add(a);
            
        }
        
        return set.size();
        
    }
}