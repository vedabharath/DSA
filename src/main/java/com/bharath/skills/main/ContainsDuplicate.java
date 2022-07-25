package com.bharath.skills.main;

import java.util.stream.Stream;

public class ContainsDuplicate {

	/*
	 * public int singleNumber(int[] nums) {
	 * 
	 * Set<Integer> set = new HashSet<>();
	 * 
	 * for (Integer num : nums) if (set.contains(num)) set.remove(num); else
	 * set.add(num);
	 * 
	 * return set.iterator().next();
	 * 
	 * }
	 */

	public int singleNumber(int[] nums) {

		int res = 0;
		int sum, mask;

		for (int i = 0; i < 32; i++) {

			sum = 0;
			mask = 1 << i;

			for (Integer num : nums)
				if ((num & mask) != 0)
					sum++;
			if (sum % 3 != 0)
				res |= mask;

		}
		return res;

	}

	public boolean containsDuplicate(int[] nums) {

		return false;
	}

	public static void main(String[] args) {
		System.out.println(new ContainsDuplicate().singleNumber(Stream.of(1, 1, 1, 2, 2, 2, 3).mapToInt(i -> {
			return i;
		}).toArray()));
	}

}
