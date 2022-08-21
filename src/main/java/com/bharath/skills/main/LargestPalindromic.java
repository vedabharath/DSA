package com.bharath.skills.main;

public class LargestPalindromic {
    public String largestPalindromic(String num) {

        int[] map = new int[10];

        boolean allZeros = true;

        for(char c: num.toCharArray()){
            map[c-'0']++;
            if(c-'0' != 0) allZeros = false;

        }

        if(allZeros) return "0";

        String bo = null;

        StringBuilder sb = new StringBuilder();

        for(int i=9;i>=0;i--){
            if(i==0 && sb.length() == 0) continue;
            String digit = String.valueOf(i);
            if(map[i]%2 == 1 && bo == null) {
                bo = digit;
            }
            sb.append(digit.repeat(map[i]/2));
        }


//        while(sb.length() > 0 && sb.charAt(0) == '0'){
//            sb.deleteCharAt(0);
//        }
        String res = sb.toString();
        if(bo != null) res += bo;
        return res + sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestPalindromic().largestPalindromic("0000"));
        System.out.println(new LargestPalindromic().largestPalindromic("444947137"));
    }
}