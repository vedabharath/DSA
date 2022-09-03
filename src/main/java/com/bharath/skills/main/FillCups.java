package com.bharath.skills.main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FillCups {

    /*
    public int fillCups(int[] A) {
        int mx = 0, sum = 0;
        for(int a: A) {
            mx = Math.max(a, mx);
            sum += a;
        }
        return Math.max(mx, (sum + 1) / 2);
    }
     */
    
    public int fillCups(int[] a) {

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2-o1);

        q.add(a[0]);
        q.add(a[1]);q.add(a[2]);

        int t = 0;

        while(!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();
            if(x > 1) q.add(x-1);
            if(y > 1) q.add(y-1);
            t++;
        }

        return t;

        
        
        
    }
}