package com.bharath.skills.main;

public class GarbageCollection {

    public int garbageCollection(String[] garbage, int[] travel) {

        int p=0,pi=0,g=0,gi=0,m=0,mi=0,t=0;

        for(int i=0;i<garbage.length;i++){

            p=0;g=0;m=0;
            for(char c: garbage[i].toCharArray()){
                if(c == 'P') p++;
                else if(c == 'G') g++;
                else m++;
            }

            t += (p+g+m);

            if(p != 0) pi = i;
            if(g != 0) gi = i;
            if(m != 0) mi = i;
        }

        for(int i=1;i< travel.length;i++)
            travel[i] += travel[i-1];

        t += ((pi>0?travel[pi-1]:0)+(mi>0?
    travel[mi-1]:0)+(gi>0?travel[gi-1]:0));

        return t;
    }

    public static void main(String[] args) {

        GarbageCollection sol = new GarbageCollection();

        System.out.println(sol.garbageCollection(
                new String[]{"G","P","GP","GG"},new int[]{2,4,3}
        ));

    }
}