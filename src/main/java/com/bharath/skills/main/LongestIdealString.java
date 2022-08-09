package com.bharath.skills.main;

import java.util.Arrays;

public class LongestIdealString {
    public int longestIdealString(String s, int k) {
        int res = 0, n = s.length(), dp[] = new int[150];
        for (int ci = 0; ci < n; ++ci) {
            int i = s.charAt(ci);
            for (int j = i - k; j <= i + k; ++j)
                dp[i] = Math.max(dp[i], dp[j]);
            res = Math.max(res, ++dp[i]);
        }
        return res;
    }

    public int longestIdealString2(String s, int k) {
        int dp[] = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int a = s.charAt(i) - 'a', mx = 0;
            for (int b = Math.max(0, a - k); b <= Math.min(25, a + k); ++b)
                mx = Math.max(mx, dp[b]);
            dp[a] = 1 + mx;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}