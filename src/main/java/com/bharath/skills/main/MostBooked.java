package com.bharath.skills.main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MostBooked {

    public int mostBooked(int n, int[][] meetings) {

        int max = 0;
        int ans = 0;
        int next = 0;
        int[] counts = new int[n];

        Arrays.sort(meetings,(a,b)->a[0]-b[0]);

        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->(a[1]==b[1]?a[0]-b[0]:a[1]-b[1]));
        PriorityQueue<Integer> op = new PriorityQueue<>();
        for(int i=0;i<n;i++) op.add(i);

        for(int[] meet: meetings){

            while(!p.isEmpty() && p.peek()[1] <= meet[0]){
                int[] rec = p.poll();
                op.add(rec[0]);
            }

            if(!op.isEmpty()){
                next = op.poll();
            }else{
                int[] rec = p.poll();
                next = rec[0];
                meet[1] = rec[1]+meet[1]-meet[0];
            }

            p.add(new int[]{next,meet[1]});

            counts[next]++;

            if(counts[next] > max||(counts[next] == max && next < ans)){
                ans = next;
                max = counts[next];
            }

        }


        return ans;

    }

    public static void main(String[] args) {

    }
}