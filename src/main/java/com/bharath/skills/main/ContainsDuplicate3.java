package com.bharath.skills.main;

import java.util.TreeSet;

class ContainsDuplicate3Solution {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		TreeSet<Long> set = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {

			long lnum = (long) nums[i];

			Long floor = set.floor(lnum);

			if (floor != null && lnum - floor <= t)
				return true;

			Long ceil = set.ceiling(lnum);

			if (ceil != null && ceil - lnum <= t)
				return true;

			set.add((long) nums[i]);

			if (set.size() > k)
				set.remove((long) nums[i - k]);

		}

		return false;

	}
}

public class ContainsDuplicate3 {

	public static void main(String[] args) {

		int[] a = { 1, 5, 9, 1, 5, 9 };
		int k = 2;
		int t = 3;

		ContainsDuplicate3Solution sol = new ContainsDuplicate3Solution();

		System.out.println(sol.containsNearbyAlmostDuplicate(a, k, t));

	}

}
