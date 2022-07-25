package com.bharath.skills.main;

public class SumOfLeftLeaves {

	static int sum = 0;

	public static void sumOfLeftLeavesUtil(TreeNode node) {

		if (node == null)
			return;
		if (node.left != null && node.left.left == null && node.left.right == null)
			sum += node.left.val;
		sumOfLeftLeavesUtil(node.left);
		sumOfLeftLeavesUtil(node.right);

	}

	public int sumOfLeftLeaves(TreeNode root) {

		SumOfLeftLeaves.sum = 0;

		SumOfLeftLeaves.sumOfLeftLeavesUtil(root);

		return SumOfLeftLeaves.sum;

	}

	public static void main(String[] args) {

	}

}
