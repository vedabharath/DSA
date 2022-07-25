package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.List;

class FizzBuzzSolution {

	public List<String> fizzBuzz(int n) {

		List<String> list = new ArrayList<String>();

		for (int i = 1; i <= n; i++) {

			if (i % 3 == 0 && i % 5 == 0)
				list.add("FizzBuzz");
			else if (i % 5 == 0)
				list.add("Buzz");
			else if (i % 3 == 0)
				list.add("Fizz");
			else
				list.add(String.valueOf(i));

		}

		return list;

	}
}

public class FizzBuzz {

	public static void main(String args[]) {
		System.out.println(new FizzBuzzSolution().fizzBuzz(15));
	}
}
