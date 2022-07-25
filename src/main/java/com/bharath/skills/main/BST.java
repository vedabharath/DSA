package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BST {

	public void getAllElements(TreeNode root, LinkedList<Integer> list) {

		if (root == null)
			return;
		getAllElements(root.left, list);
		list.add(root.val);
		getAllElements(root.right, list);

	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

		LinkedList<Integer> list1 = new LinkedList<>();
		getAllElements(root1, list1);
		LinkedList<Integer> list2 = new LinkedList<>();
		getAllElements(root2, list2);

		List<Integer> ans = new ArrayList<>();

		while (!list1.isEmpty() && !list2.isEmpty()) {
			if (list1.peek() < list2.peek())
				ans.add(list1.poll());
			else
				ans.add(list2.poll());

		}

		if (list1.isEmpty())
			ans.addAll(list2);
		else
			ans.addAll(list1);

		return ans;

	}

	public TreeNode inOrderSuccessor(TreeNode node) {

		TreeNode temp = node;

		while (temp.left != null)
			temp = temp.left;

		return temp;
	}

	public TreeNode deleteNode(TreeNode root, int key) {

		if (root == null)
			return root;

		if (key < root.val)
			root.left = deleteNode(root.left, key);
		else if (key > root.val)
			root.right = deleteNode(root.right, key);
		else {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;
			else {
				TreeNode successor = inOrderSuccessor(root.right);
				root.val = successor.val;
				root.right = deleteNode(root.right, successor.val);
			}

		}

		return root;

	}
}
