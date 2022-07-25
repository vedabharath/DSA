package com.bharath.skills.main;

import java.util.*;

class NumberOfAtomsSolution {

    int n;

    int i;

    private HashMap<String, Integer> parse(String s){

        HashMap<String, Integer> map = new HashMap<>();

        int res = 0;

        while(i<n){

            int sindex = i;

            if(s.charAt(i) == '(') {

                i++;

                HashMap<String, Integer> next = parse(s);

                for(String name: next.keySet()){
                    map.put(name, map.getOrDefault(name,0)+next.get(name));
                }

            }

            else if(s.charAt(i) == ')'){

                i++;

                res = getNum(s);

                for(String key: map.keySet())
                    map.put(key,map.get(key)*res);

                return map;

            }

            else {

                i++;

                while(i<n && Character.isLowerCase(s.charAt(i))) i++;

                String name = s.substring(sindex,i);

                res = getNum(s);

                map.put(name,map.getOrDefault(name,0)+res);

            }


        }

        return map;

    }

    private int getNum(String s) {
        int res;
        res = i < n && Character.isDigit(s.charAt(i))?0:1;

        while(i<n && Character.isDigit(s.charAt(i))){
            res = res*10+s.charAt(i)-'0';
            i++;
        }
        return res;
    }


    public String countOfAtoms(String formula) {

        this.n = formula.length();
        this.i = 0;

        HashMap<String, Integer> map = parse(formula);

        //System.out.println(map);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries,(e1, e2)->(e1.getKey().compareTo(e2.getKey())));

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String,Integer> entry: entries){
            sb.append(entry.getKey());
            if(entry.getValue() > 1)
                sb.append(entry.getValue());
        }

        //System.out.println(sb.toString());

        return sb.toString();

    }
}

public class NumberOfAtoms{

    public static void main(String[] args) {

        NumberOfAtomsSolution sol  = new NumberOfAtomsSolution();

        System.out.println(sol.countOfAtoms("(H)"));
    }

}