package com.bharath.skills.main;

import java.util.HashMap;

public class MostFrequentEven {
    
    public int mostFrequentEven(int[] nums) {
        
        int ans = -1;
                
        HashMap<Integer,Integer> counts = new HashMap<>();
        
        for(int num: nums){
            if(num%2 == 0){
            counts.put(num, counts.getOrDefault(num,0)+1);
            if(ans == -1 || counts.get(num) > counts.get(ans) || (counts.get(num) == counts.get(ans) && num < ans))
                ans = num;
            }
        }
        
        return ans;
        
    }

    public static void main(String[] args) {

    }
}