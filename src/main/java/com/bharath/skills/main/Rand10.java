package com.bharath.skills.main;

class Rand7 {

	public int rand7() {
		return (int) (Math.random() * 7 + 1);
	}
}

class Rand10Solution extends Rand7 {

	public int rand10() {
		
		int row,col,idx;
			
		do {
			
			row = rand7();
			col = rand7();
			idx = (row-1)*7 + col;
		}while(idx > 40);
		
		return 1 +(idx - 1)%10;

	}

}

public class Rand10 {

	public static void main(String[] args) {

		int n = 3;

		Rand10Solution sol = new Rand10Solution();

		for (int i = 1; i <= n; i++)
			System.out.println(sol.rand10());

	}

}
