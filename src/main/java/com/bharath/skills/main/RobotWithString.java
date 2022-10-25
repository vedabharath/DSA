package com.bharath.skills.main;

import java.util.ArrayDeque;

public class RobotWithString {
    public String robotWithString(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        int n = s.length();
        
        int[] map = new int[n];
        
        map[n-1] = 26;
        
        for(int i = n-2; i>=0; i--){
            
            map[i] = Math.min(map[i+1],s.charAt(i+1)-'a');
            
        }
        
        ArrayDeque<Character> st = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            
            st.push(s.charAt(i));
            
            while( !st.isEmpty() && map[i] >= st.peek()-'a') 
                sb.append(st.pop());
           
        }
        
        while(!st.isEmpty()) sb.append(st.pop());
        
        return sb.toString();
        
    }
}