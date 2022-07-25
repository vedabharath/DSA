package com.bharath.skills.main;

class MaxProductSubArraySolution {
	public int maxProduct(int[] nums) {

		int r = nums[0];

		for (int i = 1, imax = r, imin = r; i < nums.length; i++) {

			if (nums[i] < 0) {
				int temp = imax;
				imax = imin;
				imin = temp;
			}

			imax = Math.max(nums[i], imax * nums[i]);
			imin = Math.min(nums[i], imin * nums[i]);

			r = Math.max(r, imax);
		}
		return r;

	}
}

public class MaxProductSubArray {

	public static void main(String[] args) {

		MaxProductSubArraySolution sol = new MaxProductSubArraySolution();

		int nums[] = { 2, 3, -5, 8, -1 };

		System.out.println(sol.maxProduct(nums));

	}

}
