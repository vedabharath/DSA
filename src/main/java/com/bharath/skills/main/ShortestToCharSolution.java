package com.bharath.skills.main;

import java.util.Arrays;
import java.util.Iterator;

public class ShortestToCharSolution {

    public int[] shortestToChar(String s, char c) {

        int first = 0, second = 0;
        int[] answers = new int[s.length()];

        while (s.charAt(first) != c)
            first++;

        second = first + 1;

        while (second < s.length() && s.charAt(second) != c)
            second++;

        for (int i = 0; i < s.length(); i++) {
            if (i == second) {
                first = second;
                second = first + 1;
                while (second < s.length() && s.charAt(second) != c)
                    second++;
            }

            if (second == s.length())
                answers[i] = Math.abs(first - i);
            else
                answers[i] = Math.min(Math.abs(first - i), Math.abs(second - i));
        }


        return answers;

    }

}

class ShortestToChar {

    public static void main(String[] args) {

        ShortestToCharSolution sol = new ShortestToCharSolution();

        String s = "aaab";

        System.out.println(Arrays.toString(sol.shortestToChar(s, 'b')));

        Iterator<Integer> itr = Arrays.asList(1,2,3).listIterator();

        itr.next();

    }
}