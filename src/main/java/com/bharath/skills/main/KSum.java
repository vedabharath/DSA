package com.bharath.skills.main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSum {

    private PriorityQueue<Long> q = new PriorityQueue<>();

    int n=0,k=0;

    private void ksumUtil(int[] a, int i, Long sum){

        if(i == n){
            q.add(sum);
            if(q.size()>k) q.poll();
            return;
        }

        ksumUtil(a,i+1,sum+a[i]);
        ksumUtil(a,i+1,sum);

    }

    class Pair{
        long sum;
        int index;

        Pair(long sum, int index){

            this.sum = sum;
            this.index = index;
        }
    }

    public long kSum(int[] nums, int k) {

        this.k = k;
        this.n = nums.length;

        PriorityQueue<Pair> q = new PriorityQueue<Pair>((a,b)->a.sum>b.sum?1:a.sum<b.sum?-1:0);

        long max = 0;
        for(int i=0;i<n;i++){
            if(nums[i] > 0) max += nums[i];
            else nums[i] = -nums[i];
        }

        q.add(new Pair(-max,0));
        Arrays.sort(nums);

        while(k-- > 0){

            Pair pair = q.poll();
            max = pair.sum;
            int i = pair.index;

            if(i >= n) continue;

            q.add(new Pair(max+nums[i],i+1));
            if(i > 0)
                q.add(new Pair(max-nums[i-1]+nums[i],i+1));
        }
        return  -max;
        
    }

    public static void main(String[] args) {

        KSum sol = new KSum();

        System.out.println(sol.kSum(new int[]{2,4,-2},5));
        System.out.println(sol.kSum(new int[]{1,-2,3,4,-10,12},16));

    }
}