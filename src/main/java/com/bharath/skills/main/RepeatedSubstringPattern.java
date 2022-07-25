package com.bharath.skills.main;

class RepeatedSubstringPatternSolution {

	public boolean repeatedSubstringPattern(String s) {

		return (s + s).substring(1, 2 * s.length() - 1).contains(s);

		/*
		 * for (int i = 1; i <= (s.length() / 2); i++) { String sub = s.substring(0, i);
		 * int j = i; while (j + i <= s.length()) { if (!sub.equals(s.substring(j, j +
		 * i))) {
		 * 
		 * break; } j += i; } if (j >= s.length()) return true;
		 * 
		 * }
		 * 
		 * return false;
		 */

	}
}

public class RepeatedSubstringPattern {

	public static void main(String[] args) {

		String s = "abcdabc";

		RepeatedSubstringPatternSolution sol = new RepeatedSubstringPatternSolution();

		System.out.println(sol.repeatedSubstringPattern(s));

	}

}
