package com.bharath.skills.main;

class SmallestSubsequenceSolution {

    public String smallestSubsequence(String s) {

        int[] map = new int[26];

        for(int i=0;i<s.length();i++){

            map[s.charAt(i)-'a']=i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(i == map[s.charAt(i)-'a'])
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}

public class SmallestSubsequence {



    public static void main(String[] args) {
        SmallestSubsequenceSolution sol = new SmallestSubsequenceSolution();
        System.out.println(sol.smallestSubsequence("cbacdcbc"));
    }



}
