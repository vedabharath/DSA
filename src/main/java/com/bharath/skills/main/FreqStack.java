package com.bharath.skills.main;

import java.util.*;
import java.util.LinkedList;

class FreqStack {

    HashMap<Integer, LinkedList<Integer>> freqMap;
    HashMap<Integer, Integer> counts;
    int max;

    public FreqStack() {

        freqMap = new HashMap<>();
        counts = new HashMap<>();
        max = 0;

    }

    public void push(int x) {

        counts.merge(x, 1, (oldVal, newVal) -> oldVal + 1);
        freqMap.putIfAbsent(counts.get(x), new LinkedList());
        freqMap.get(counts.get(x)).add(x);
        if (counts.get(x) > max) max = counts.get(x);


    }

    public int pop() {

        LinkedList<Integer> list = freqMap.get(max);
        int x = list.removeLast();
        if (list.isEmpty())
            max--;
        counts.put(x, counts.get(x) - 1);
        return x;

    }
}

class FreqStackDriver {

    public static void main(String[] args) {

        FreqStack stack = new FreqStack();
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(2);
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        stack.push(2);
        stack.push(2);
        stack.push(1);
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());


    }
}