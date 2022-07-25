package com.bharath.skills.main;


class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0)
            return head;

        ListNode tail = head;
        ListNode temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
            if (temp != null)
                tail = temp;
        }

        if (k % length == 0)
            return head;

        k = length - k % length - 1;

        temp = head;

        while (k != 0) {
            temp = temp.next;
            k--;

        }

        ListNode newHead = temp.next;
        temp.next = null;
        tail.next = head;

        return newHead;
    }

}