package com.bharath.skills.main;

class LargestTimeSolution {

	int maxTime = -1;

	private void swap(int[] a, int i, int j) {
		if (i != j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	private void permutate(int[] a, int start) {

		if (start == a.length) {
			buildTime(a);
			return;
		}
		for (int i = start; i < a.length; i++) {
			swap(a, i, start);
			permutate(a, start + 1);
			swap(a, i, start);
		}
	}

	private void buildTime(int[] a) {

		int hours = a[0] * 10 + a[1];
		int minutes = a[2] * 10 + a[3];

		if (hours < 24 && minutes < 60) {
			maxTime = Math.max(maxTime, hours * 60 + minutes);
		}

	}

	public String largestTimeFromDigits(int[] A) {

		this.maxTime = -1;

		permutate(A, 0);

		if (this.maxTime == -1)
			return "";
		return String.format("%02d:%02d", maxTime / 60, maxTime % 60);

	}
}

public class LargestTime {

	public static void main(String[] args) {

		LargestTimeSolution sol = new LargestTimeSolution();

		int[] a = { 2, 0,6,9 };

		System.out.println(sol.largestTimeFromDigits(a));
	}

}
