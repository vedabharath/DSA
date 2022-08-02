package com.bharath.skills.main;

import java.util.Arrays;

public class ShortestImpossibleSequence {
    public int shortestSequence(int[] rolls, int k) {

        boolean[] map = new boolean[k+1];

        int found = 0;
        int round = 0;

        for(int i=0;i<rolls.length;i++){
            if(!map[rolls[i]]){
                found++;
                map[rolls[i]] = true;
            }
            if(found == k){
                round++;
                found = 0;
                Arrays.fill(map,false);
            }
        }

        return round+1;

    }

}