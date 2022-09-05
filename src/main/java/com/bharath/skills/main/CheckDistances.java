package com.bharath.skills.main;

import java.util.Arrays;

public class CheckDistances {
    /*public boolean checkDistances(String s, int[] distance) {

        int[] map = new int[26];

        for(int i=0;i<s.length();i++){

            int  index = s.charAt(i)-'a';

            if(map[index] != 0)
                map[index] = i-map[index]-1;
            else map[index] = i;

        }

        for(int i=0;i<26;i++){
            if(map[i] != 0 && distance[i] != map[i]) return  false;
        }

        return  true;
        
        
        
    }*/
        public boolean checkDistances(String s, int[] d) {
            int[] v= new int[26];
            Arrays.fill(v,-1);
            for(int i=0;i<s.length();i++){
                int idx= s.charAt(i)-'a';
                //fALSE - if was seen already and distance from last occurence is not equal to distance given
                if(v[idx]!=-1 && (i-v[idx]-1)!=d[idx]) return false;
                v[idx]=i;  //UPDATE THE LATEST INDEX
            }
            return true;
        }

    public static void main(String[] args) {

    }
}