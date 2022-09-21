package com.bharath.skills.main;

import java.util.Arrays;

public class PartitionString {
    public int partitionString(String s) {
        
        boolean[] has = new boolean[26];
        
        int round = 1;
        
        for(char c: s.toCharArray()){
            
            if(has[c-'a']) {
                Arrays.fill(has,false);
                round++;
            }
            
             has[c-'a'] = true;           
            
        }
        
        return round;
        
    }
}