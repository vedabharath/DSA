package com.bharath.skills.main;

class TeemoAttackSolution {

	public int findPoisonedDuration(int[] timeSeries, int duration) {

		int poisonedTime = 0;
		int poisonLasts = 0;

		for (int num : timeSeries) {

			if (poisonLasts > num)

				poisonedTime += num + duration - poisonLasts;
			else

				poisonedTime += duration;

			poisonLasts = num + duration;

		}
		return poisonedTime;

	}
}

public class TeemoAttack {

	public static void main(String[] args) {

		int[] timeSeries = { 1, 3, 5, 6 };
		TeemoAttackSolution sol = new TeemoAttackSolution();
		System.out.println(sol.findPoisonedDuration(timeSeries, 2));

	}

}
