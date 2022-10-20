package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GoodIndices {

    public List<Integer> goodIndices(int[] nums, int k) {

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        LinkedList<Integer> pre = new LinkedList<>();

        boolean[] left = new boolean[n];
        boolean[] right = new boolean[n];

        for(int i=0;i<n-k;i++){
            if(!pre.isEmpty() && nums[pre.peekLast()] < nums[i]) pre.clear();
            pre.add(i);
            if(pre.size() >= k) left[i+1] = true;
        }

        pre.clear();

        for(int i=n-1;i>=k;i--){
            if(!pre.isEmpty() && nums[pre.peekLast()] < nums[i]) pre.clear();
            pre.add(i);
            if(pre.size() >= k) right[i-1] = true;
        }

        for(int i=0;i<n;i++)
            if(left[i] && right[i])
              ans.add(i);

            return ans;


    }

    public static void main(String[] args) {

        GoodIndices sol = new GoodIndices();
        //int[] nums = new int[]{2,1,1,1,3,4,1};
        int[] nums = new int[]{2,1,1,2};
        System.out.println(Arrays.asList(sol.goodIndices(nums,2)));

    }
}