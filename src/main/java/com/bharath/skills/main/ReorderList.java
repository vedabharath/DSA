package com.bharath.skills.main;
class LinkedList {

	ListNode head;

	public void insert(int val) {

		ListNode node = new ListNode(val);

		if (head == null) {
			head = node;
			return;
		}

		ListNode temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;

	}

}

public class ReorderList {

	private static final String DELIMITER = "->";

	private static final String EMPTY = "";

	public static ListNode reverse(ListNode head) {

		ListNode next, temp;

		next = null;

		while (head != null) {

			temp = head.next;
			head.next = next;
			next = head;
			head = temp;

		}

		return next;

	}

	public static ListNode midNode(ListNode head) {

		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	public static void reorderList(ListNode head) {

		if (head == null)
			return;

		ListNode first = head, t1, t2;

		ListNode mid = ReorderList.midNode(head);

		ListNode second = mid.next;

		mid.next = null;

		second = ReorderList.reverse(second);

		while (second != null) {

			t1 = first.next;
			first.next = second;
			t2 = second.next;
			second.next = t1;
			first = t1;
			second = t2;

		}

	}

	public static void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + ((temp.next == null) ? EMPTY : DELIMITER));
			temp = temp.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		for (int i = 0; i < 1; i++)
			list.insert(i + 1);

		ReorderList.printList(list.head);

		ReorderList.reorderList(list.head);

		ReorderList.printList(list.head);

		/*
		 * ListNode first = ReorderList.midNode(list.head);
		 * 
		 * ListNode second = first.next;
		 * 
		 * first.next = null;
		 * 
		 * ReorderList.printList(list.head);
		 * 
		 * second = ReorderList.reverse(second);
		 * 
		 * ReorderList.printList(second);
		 */

	}

}
