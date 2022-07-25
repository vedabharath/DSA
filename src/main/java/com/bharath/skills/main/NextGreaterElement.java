package com.bharath.skills.main;

class NextGreaterElementSolution {

    private void swap(StringBuilder sb, int i, int j){

        char temp = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
    }

    public int nextGreaterElement(int n) {

        StringBuilder s = new StringBuilder(String.valueOf(n));

        int i;

        for(i=s.length()-1;i>0;i--)
            if(s.charAt(i-1) < s.charAt(i)) break;

        if(i==0) return -1;

        char temp = s.charAt(i-1);

        int j;

        for(j=s.length()-1;j>=i;j--)
            if(temp < s.charAt(j)) break;

        swap(s,i-1,j);

        int l = i, r = s.length()-1;

        while(l < r)
            swap(s,l++,r--);

        try{
            return Integer.parseInt(s.toString());
        }catch(Exception ex){
            return -1;
        }



    }
}
