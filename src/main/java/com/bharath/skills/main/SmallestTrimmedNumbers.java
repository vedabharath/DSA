package com.bharath.skills.main;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SmallestTrimmedNumbers {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            List<Pair<String, Integer>> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(new Pair(nums[j].substring(nums[j].length() - queries[i][1]), j));
            }
            Collections.sort(list, (a, b) -> a.getKey().compareTo(b.getKey()));
            res[i] = list.get(queries[i][0] - 1).getValue();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}