package com.bharath.skills.main;

class SumToLeafNodeSolution {

	int sum = 0;

	public void sumRootToLeafUtil(TreeNode root, int n) {

		if (root == null)
			return;
		n = n << 1 | root.val;
		if (root.left == null && root.right == null)
			sum += n;
		sumRootToLeafUtil(root.left, n);
		sumRootToLeafUtil(root.right, n);

	}

	public int sumRootToLeaf(TreeNode root) {

		sum = 0;

		sumRootToLeafUtil(root, 0);

		return sum;

	}
}

public class SumToLeafNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
