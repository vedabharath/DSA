package com.bharath.skills.main;

import java.util.HashMap;
import java.util.Objects;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val &&
                Objects.equals(next, node.next) &&
                Objects.equals(random, node.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, random);
    }
}

class copyRandomListSolution {

    public Node copyRandomListInterweaving(Node head) {

        Node node = head;
        Node temp = null;

        while (node != null) {

            temp = node.next;
            node.next = new Node(node.val);
            node.next.next = temp;
            node = temp;

        }
        node = head;
        Node copiedHead = node.next;

        while (node != null) {
            node.next.random = node.random==null?null:node.random.next;
            node = node.next.next;
        }

        node = head;
        while(node != null){
            temp = node.next;
            node.next = temp.next;
            node = temp.next;
            temp.next = temp.next==null?null:temp.next.next;

        }

        return copiedHead;

    }

    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();

        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        Node copiedNode = null;
        while (node != null) {
            copiedNode = map.get(node);
            copiedNode.next = map.get(node.next);
            copiedNode.random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);

    }
}

public class copyRandomList {
}
