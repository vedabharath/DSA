package com.bharath.skills.main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {


        TreeMap<Integer, String> map = new TreeMap<>();

        for(int i=0;i< names.length;i++){
            map.put(heights[i],names[i]);
        }

        Iterator<Integer> itr = map.descendingKeySet().iterator();

        String[] res = new String[names.length];

        int i=0;

        while(itr.hasNext()){
            res[i++]  = map.get(itr.next());
        }

        return res;
    }
}