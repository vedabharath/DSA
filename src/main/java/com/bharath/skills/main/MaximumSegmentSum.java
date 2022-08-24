package com.bharath.skills.main;

public class MaximumSegmentSum {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        DSU dsu = new DSU(n);
        long[] ans = new long[n];
        for(int i = n - 1; i > 0; i--) {
            ans[i - 1] = dsu.add(removeQueries[i], nums[removeQueries[i]]);
        }
        return ans;
    }
}

class DSU {
    int[] roots;
    long[] sums;
    int[] heights;
    int n;
    long msf;
    
    DSU(int n) {
        this.n = n;
        roots = new int[n];
        sums = new long[n];
        heights = new int[n];
        for(int i = 0; i < n; i++) {
            roots[i] = i;
            heights[i] = 1;
        }
        msf = 0;
    }
    
    public long add(int i, int val) {
        sums[i] = ln(val);
        if(i - 1 >= 0 && sums[i - 1] > 0) connect(i, i - 1);
        if(i + 1 < n && sums[i + 1] > 0) connect(i, i + 1);
        msf = Math.max(msf, sums[i]);
        return msf;
    }
    
    private int root(int u) {
        if(roots[u] != u) {
            roots[u] = root(roots[u]);
        }
        return roots[u];
    }
    
    private void connect(int u, int v) {
        int rU = root(u);
        int rV = root(v);
        if(rU == rV) return;
        int hU = heights[rU];
        int hV = heights[rV];
        
        if(hU <= hV) {
            roots[rU] = rV;
            if(hU == hV) heights[rV]++;
            sums[rV] += sums[rU];
            msf = Math.max(msf, sums[rV]);
            return;
        }
        roots[rV] = rU;
        sums[rU] += sums[rV];
        msf = Math.max(msf, sums[rU]);
    }
    
    private long ln(int val) { return Long.valueOf(val); }
}