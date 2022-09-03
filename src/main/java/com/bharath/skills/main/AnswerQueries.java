package com.bharath.skills.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class AnswerQueries {

    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        TreeMap<Integer,Integer> map = new TreeMap<>();

        int sum = 0;

        for(int i=0;i< nums.length;i++){

            sum+= nums[i];
            map.put(sum,i+1);

        }

        int[] res = new int[queries.length];

        for(int i=0;i< queries.length;i++){
            Integer floor = map.floorKey(queries[i]);
            res[i] = floor==null?0:map.get(floor);
        }

        return res;
        
    }

    public static void main(String[] args) {
        AnswerQueries sol = new AnswerQueries();

        System.out.println(sol.answerQueries(new int[]{4,5,2,1},
new int[]{3,10,21}
));

    }
}