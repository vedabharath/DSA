package com.bharath.skills.main;

class HouseRobberSolution {

	private int rob(int[] nums, int[] profit, int houseNo) {

		if (houseNo >= nums.length)
			return 0;

		if (profit[houseNo] == -1)
			profit[houseNo] = Math.max(rob(nums, profit, houseNo + 1), nums[houseNo] + rob(nums, profit, houseNo + 2));

		return profit[houseNo];

	}

	public int rob(int[] nums) {

		int next = 0, nextnext = 0;

		for (int i = nums.length - 1; i >= 0; i--) {
			int temp = next;
			next = Math.max(nums[i] + nextnext, next);
			nextnext = temp;
		}

		return next;

	}
}

public class HouseRobber {

	public static void main(String[] args) {

		int[] nums = { 2, 3, 4, 1, 1, 15, 8 };

		HouseRobberSolution sol = new HouseRobberSolution();

		System.out.println(sol.rob(nums));

	}

}
