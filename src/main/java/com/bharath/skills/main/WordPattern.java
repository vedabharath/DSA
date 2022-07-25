package com.bharath.skills.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class WordPatternSolution {
	public boolean wordPattern(String pattern, String str) {

		HashMap map = new HashMap<>();

		String[] words = str.split(" ");

		if (words.length != pattern.length())
			return false;

		for (int i = 0; i < words.length; i++) {

			char c = pattern.charAt(i);
			String w = words[i];
			if (!map.containsKey(c))
				map.put(c, i);
			if (!map.containsKey(w))
				map.put(w, i);
			if (map.get(c) != map.get(w))
				return false;

		}

		return true;

	}

	public boolean wordPattern2(String pattern, String str) {

		Map<Character, String> letterMap = new HashMap<>();
		Set<String> wordSet = new HashSet<>();

		String[] words = str.split(" ");
		char[] letters = pattern.toCharArray();

		if (words.length != letters.length)
			return false;

		for (int i = 0; i < letters.length; i++) {
			if (!letterMap.containsKey(letters[i]) && !wordSet.contains(words[i])) {
				letterMap.put(letters[i], words[i]);
				wordSet.add(words[i]);
			} else if (!words[i].equals(letterMap.get(letters[i])))
				return false;

		}

		return true;

	}
}

public class WordPattern {

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog dog dog dog";

		WordPatternSolution sol = new WordPatternSolution();
		System.out.println(sol.wordPattern(pattern, str));

	}

}
