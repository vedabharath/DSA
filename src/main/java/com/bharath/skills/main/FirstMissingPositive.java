package com.bharath.skills.main;

class FirstMissingPositiveSolution {

	public int firstMissingPositive(int[] nums) {

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0 || nums[i] > n)
				nums[i] = n + 1;

		}

		for (int num : nums) {

			num = Math.abs(num);

			if (num > n)
				continue;

			num--;

			if (nums[num] > 0)
				nums[num] = -1 * nums[num];
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0)
				return i + 1;
		}

		return n + 1;

	}
}

public class FirstMissingPositive {

	public static void main(String[] args) {

		FirstMissingPositiveSolution sol = new FirstMissingPositiveSolution();

		int[] nums = { 1, 2, 3, 4 };

		System.out.println(sol.firstMissingPositive(nums));

	}

}
