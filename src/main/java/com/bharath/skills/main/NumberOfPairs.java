package com.bharath.skills.main;

public class NumberOfPairs {

    public int[] numberOfPairs(int[] nums) {

        int[] map = new int[101];
        for(int num: nums)
            map[num]++;

        int pairs = 0;

        for(int i=0;i<101;i++)
            pairs += map[i]/2;


        return new int[]{pairs,nums.length-pairs*2};
        
    }

    public static void main(String[] args) {

    }
}