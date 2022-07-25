package com.bharath.skills.main;

class CoinChange {

	static int[] memo;

	public static int coinChange(int[] coins, int amount) {

		memo = new int[amount + 1];

		for (int i = 1; i <= amount; i++) {

			int min = Integer.MAX_VALUE;
			boolean canMake = false;

			for (int coin : coins) {

				if (i - coin >= 0 && memo[i - coin] != -1) {
					min = Math.min(min, 1 + memo[i - coin]);
					canMake = true;
				}

			}

			memo[i] = canMake ? min : -1;

		}

		return memo[amount];

	}

	public static void main(String[] args) {

		System.out.println(coinChange(new int[] { 1, 2, 5 }, 15));
		System.out.println(coinChange(new int[] { 2 }, 3));

	}
}


