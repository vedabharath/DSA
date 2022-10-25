package com.bharath.skills.main;

public class HardestWorker {
    public int hardestWorker(int n, int[][] logs) {
        
        int max = logs[0][1], id = logs[0][0], d = logs[0][1];
        
        for(int i=1;i<logs.length;i++){
            
            d = logs[i][1]-logs[i-1][1];
            
            if(d >= max){
                id = d == max?Math.min(id,logs[i][0]):logs[i][0];
                max  = d;
            }
        }
        
        return id;
        
    }

    public static void main(String[] args) {
        HardestWorker sol = new HardestWorker();
        System.out.println( sol.hardestWorker(10,new int[][]{{0,3},{2,5},{0,9},{1,15}}));;
    }
}