package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PancakeSortSolution {

	public void flip(int[] arr, int i) {

		int start = 0, temp;

		while (start < i) {
			temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
			start++;
			i--;
		}

	}

	public int findMax(int[] arr, int n) {

		int mi = 0;
		for (int i = 0; i < n; i++)
			if (arr[i] > arr[mi])
				mi = i;

		return mi;
	}

	public void sort(int[] arr) {

		int currSize = arr.length;

		while (currSize > 1) {

			int mi = findMax(arr, currSize);

			if (mi != currSize - 1) {
				flip(arr, mi);
				flip(arr, currSize - 1);
			}

			currSize--;
		}
	}

	public List<Integer> pancakeSort(int[] A) {

		List<Integer> list = new ArrayList<>();

		for (int currSize = A.length; currSize > 1; currSize--) {

			int mi = findMax(A, currSize);

			if (mi == currSize - 1)
				continue;

			if (mi != 0) {
				list.add(mi + 1);
				flip(A, mi);
			}

			list.add(currSize);
			flip(A, currSize - 1);

		}

		return list;

	}
}

public class PancakeSort {

	public static void main(String[] args) {

		PancakeSortSolution sol = new PancakeSortSolution();

		int[] arr = { 1, 2, 3, 4 };

		List<Integer> list = sol.pancakeSort(arr);

		System.out.println(list);

		System.out.println(Arrays.toString(arr));

	}

}
