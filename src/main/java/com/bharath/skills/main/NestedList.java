package com.bharath.skills.main;

import com.bharath.skills.defs.NestedInteger;

import java.util.*;
import java.util.LinkedList;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class NestedListSolution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger()*depth;
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }

    public String printNi(NestedInteger thisNi, StringBuilder sb){
        if(thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");
        }
        sb.append("[");
        for(NestedInteger ni : thisNi.list){
            if(ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            }
            else {
                printNi(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        //[[1,1],2,[1,1]]

        List<NestedInteger> list = new ArrayList<>();

        NestedInteger ni = new NestedInteger();

        ni.add(new NestedInteger(1));
        ni.add(new NestedInteger(1));

        list.add(ni);

       ni = new NestedInteger();

        ni.setInteger(2);

        list.add(ni);

        ni = new NestedInteger();

        ni.add(new NestedInteger(1));
        ni.add(new NestedInteger(1));

        list.add(ni);

        NestedListSolution nls = new NestedListSolution();
        System.out.println(nls.depthSum(list));


        //[1,[4,[6]]]

        NestedInteger ni1 = new NestedInteger();
        ni1.add(new NestedInteger(6));

        NestedInteger ni2 = new NestedInteger();
        ni2.add(new NestedInteger(4));
        ni2.add(ni1);

        NestedInteger ni3 = new NestedInteger();
        ni3.add(new NestedInteger(1));
        ni3.add(ni2);

        System.out.println(nls.depthSum(ni3.getList()));
        System.out.println(nls.printNi(ni3,new StringBuilder()));


    }
}
