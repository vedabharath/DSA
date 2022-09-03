package com.bharath.skills.main;

import java.util.HashMap;

public class MaximumSum {

    private int sum(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        int max = -1;

        for(int num: nums){

            int sum = sum(num);
            if(!map.containsKey(sum))
                map.put(sum,num);
            else {

                max = Math.max(max,map.get(sum)+num);
                if(map.get(sum) < num) map.put(sum,num);

            }

        }
        return max;
    }

    public static void main(String[] args) {

    }
}