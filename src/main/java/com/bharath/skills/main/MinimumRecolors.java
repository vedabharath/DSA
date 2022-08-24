package com.bharath.skills.main;

public class MinimumRecolors {

    public int minimumRecolors(String blocks, int k) {
        int back = 0, front = 0, count_w = 0, ans = 101;
        while(front < blocks.length()){
            if(blocks.charAt(front) == 'W'){ count_w++; }
            if(front - back + 1 == k){
                ans = Math.min(ans, count_w);
                if(blocks.charAt(back) == 'W') count_w--;
                back++;
            }
            front++;
        }
        return ans;
    }

    public static void main(String[] args) {

        MinimumRecolors sol = new MinimumRecolors();
        System.out.println(sol.minimumRecolors("WBWBBBW",2));

    }
}