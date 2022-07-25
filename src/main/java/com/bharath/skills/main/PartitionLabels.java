package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PartitionLabelsSolution {

	public int nextPartition(String s, int start) {

		int patitionIndex = s.lastIndexOf(s.charAt(start));

		for (int i = start + 1; i < patitionIndex; i++) {

			int currLastIndex = s.lastIndexOf(s.charAt(i));

			if (currLastIndex > patitionIndex)
				patitionIndex = currLastIndex;
		}

		return patitionIndex;

	}

	public List<Integer> partitionLabels(String s) {

		List<Integer> list = new ArrayList<>();

		Map<Character, Integer> map = new HashMap<>();

		for (int i = s.length() - 1; i >= 0; i--) {
			if (!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), i);
		}

		int start = 0;
		int paritionIndex;

		do {

			paritionIndex = map.get(s.charAt(start));

			for (int i = start + 1; i < paritionIndex; i++) {

				int currLastIndex = map.get(s.charAt(i));

				if (currLastIndex > paritionIndex)
					paritionIndex = currLastIndex;
			}

			list.add(paritionIndex - start + 1);
			start = paritionIndex + 1;

		} while (start < s.length());

		return list;

	}
}

public class PartitionLabels {

	public static void main(String[] args) {

		 String s = "ababcbacadefegdehijhklij";
		//String s = "abccaddbeffe";

		PartitionLabelsSolution sol = new PartitionLabelsSolution();

		System.out.println(sol.partitionLabels(s));

	}

}
