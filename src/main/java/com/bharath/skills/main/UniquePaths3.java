package com.bharath.skills.main;

class UniquePaths3Solution {

	public static int uniquePaths;
	public static int rows;
	public static int cols;

	public static final int[] rowOffsets = { 0, 0, -1, 1 };
	public static final int[] colOffsets = { -1, 1, 0, 0 };

	public void uniquePathsUtil(int[][] grid, int row, int col, int nonEmptySquares) {

		if (grid[row][col] == 2 && nonEmptySquares == 1) {
			uniquePaths++;
			return;
		}

		int temp = grid[row][col];
		grid[row][col] = -2;
		nonEmptySquares--;

		for (int i = 0; i < 4; i++) {

			int nextrow = row + rowOffsets[i];
			int nextCol = col + colOffsets[i];

			if (nextrow >= rows || nextrow < 0 || nextCol >= cols || nextCol < 0 || grid[nextrow][nextCol] < 0)
				continue;

			uniquePathsUtil(grid, nextrow, nextCol, nonEmptySquares);
		}

		grid[row][col] = temp;

	}

	public int uniquePathsIII(int[][] grid) {

		uniquePaths = 0;
		rows = grid.length;
		cols = grid[0].length;
		int nonEmptySquares = 0;

		int m = 0;
		int n = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					m = i;
					n = j;
				}
				if (grid[i][j] >= 0) {
					nonEmptySquares++;
				}

			}
		}

		uniquePathsUtil(grid, m, n, nonEmptySquares);

		return uniquePaths;

	}
}

public class UniquePaths3 {

	public static void main(String[] args) {

		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };

		UniquePaths3Solution sol = new UniquePaths3Solution();

		System.out.println(sol.uniquePathsIII(grid));

	}

}
