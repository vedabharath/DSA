package com.bharath.skills.main;


class DecodeWaysSolution {

    private int decode(int i, String s){

        //System.out.println(i +" "+s);

        if(i > s.length()) return 0;

        if(i == s.length()) return 1;

        if(i+1 < s.length() && s.charAt(i) != '0'  && Integer.parseInt(s.substring(i,i+2))<= 26)
            return decode(i+1,s) + decode(i+2,s);

        return decode(i+1,s);


    }
    public int numDecodings(String A) {


        return decode(0,A);


    }


}


public class DecodeWays {

    public static void main(String[] args) {
        DecodeWaysSolution sol = new DecodeWaysSolution();
        System.out.println(sol.numDecodings("2026"));
    }
}
