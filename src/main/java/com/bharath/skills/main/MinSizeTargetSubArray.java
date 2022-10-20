package com.bharath.skills.main;

public class MinSizeTargetSubArray {

    public int minSizeTargetSubArray(int[] a, int target){

        int l=0, r = 0, n = a.length, cur = 0, ans = n;

        while(r < n){

            cur += a[r];

            while(cur >= target){

                ans = Math.min(ans,r-l+1);
                cur -= a[l++];
            }

            r++;

        }

        return ans;
    }
}
