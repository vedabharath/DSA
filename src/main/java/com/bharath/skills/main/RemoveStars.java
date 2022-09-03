package com.bharath.skills.main;

import java.util.LinkedList;

public class RemoveStars {

    public String removeStars(String s) {

        LinkedList<Character> st = new LinkedList<>();

        for(char c: s.toCharArray()){

            if(c == '*') st.pop();
            else st.push(c);
        }

        StringBuilder sb = new StringBuilder();

        for(char c: st){
            sb.append(c);
        }

        return  sb.reverse().toString();
    }

    public static void main(String[] args) {

        RemoveStars sol = new RemoveStars();

        System.out.println(sol.removeStars("leet**cod*e"));

    }
}