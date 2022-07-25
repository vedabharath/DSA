package com.bharath.skills.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreakSolution {

	Set<String> dict = null;
	int[] canBreak = null;
	String s = null;

	public boolean wordBreak(int index) {

		if (canBreak[index] == 1)
			return true;

		if (canBreak[index] == 0)
			return false;

		for (int i = index; i < s.length(); i++) {
			if (dict.contains(s.substring(index, i + 1)) && wordBreak(i + 1)) {
				canBreak[index] = 1;
				return true;
			}

		}

		canBreak[index] = 0;
		return false;

	}

	public boolean wordBreak(String s, List<String> wordDict) {

		dict = new HashSet<>(wordDict);
		canBreak = new int[s.length() + 1];
		Arrays.fill(canBreak, -1);
		canBreak[s.length()] = 1;
		this.s = s;

		return wordBreak(0);

	}
}

public class WordBreak {

	public static void main(String[] args) {

		WordBreakSolution sol = new WordBreakSolution();

		String s = "applepenapple";

		System.out.println(sol.wordBreak(s, Arrays.asList("apple", "pe", "n")));

	}
}
