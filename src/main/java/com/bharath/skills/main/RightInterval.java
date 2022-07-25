package com.bharath.skills.main;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

class RightIntervalSolution {

	public int[] findRightInterval(int[][] intervals) {

		TreeMap<Integer, Integer> map = new TreeMap<>();

		int[] res = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++)
			map.put(intervals[i][0], i);

		for (int i = 0; i < intervals.length; i++) {
			int end = intervals[i][1];
			Entry<Integer, Integer> ceilEntry = map.ceilingEntry(end);
			res[i] = ceilEntry == null ? -1 : ceilEntry.getValue();
		}

		return res;

	}
}

public class RightInterval {

	public static void main(String[] args) {

		System.out.println(Arrays
				.toString(new RightIntervalSolution().findRightInterval(new int[][] { { 1, 4 }, { 2, 3 }, { 3, 4 } })));

	}

}
