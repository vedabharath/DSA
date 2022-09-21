package com.bharath.skills.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinGroups {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int[] interval: intervals){
            if(!minHeap.isEmpty() && minHeap.peek()<interval[0]) minHeap.remove();
            minHeap.offer(interval[1]);
        }
        return minHeap.size();
    }
}