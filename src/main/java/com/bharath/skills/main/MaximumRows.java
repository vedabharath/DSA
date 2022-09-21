package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MaximumRows {

    int[] masks;
    int cols, n, ans=0;

    private void util(int mask, int start){

        if(Integer.bitCount(mask) == n){
            int count = 0;
            for(int m: masks){
                if((m & mask) == m) count++;
            }
            ans = Math.max(ans,count);
            return;
        }

        for(int c=start;c<cols;c++){
            mask |= 1<<c;
            util(mask,start+1);
            mask ^= 1<<c;
        }
    }
    
    public int maximumRows(int[][] m, int numSelect) {

        this.masks = new int[m.length];
        this.n = numSelect;
        this.cols = m[0].length;
        
        for(int i=0;i<m.length;i++){
            int count = 0;
            for(int j=0;j<m[0].length;j++){
                if(m[i][j] == 1) masks[i] |= 1<<j;
            }
            
        }

        util(0,0);

        return  ans;
        
    }

    public static void main(String[] args) {

        MaximumRows sol = new MaximumRows();

        int[][] m = new int[][]{{0,0,0},{1,0,1},{0,1,1},{0,0,1}};

        System.out.println(sol.maximumRows(m,2));


    }
}