package com.bharath.skills.main;

import java.util.*;

public class LargestNumberPostiveNegative {

    public int solution(int[] A) {

        Set<Integer> set = new HashSet<>();

        int res = 0;

        for(int a: A){
            set.add(a);
            if(set.contains(-1*a))
                res = Math.max(res, Math.abs(a));
        }

        return res;


    }
}
