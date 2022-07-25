package com.bharath.skills.main;

import java.util.Iterator;
import java.util.TreeMap;

class CarPoolingSolution {

	public boolean carPooling(int[][] trips, int capacity) {

		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < trips.length; i++) {

			int pas = trips[i][0];

			map.compute(trips[i][1], (k, v) -> (v == null) ? pas : v + pas);
			map.compute(trips[i][2], (k, v) -> (v == null) ? -pas : v - pas);

		}

		Iterator<Integer> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			capacity -= map.get(itr.next());
			if (capacity < 0)
				return false;

		}
		return true;
	}
}

public class CarPooling {

	public static void main(String[] args) {

		int[][] trips = { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } };

		CarPoolingSolution sol = new CarPoolingSolution();

		System.out.println(sol.carPooling(trips, 11));

	}

}
