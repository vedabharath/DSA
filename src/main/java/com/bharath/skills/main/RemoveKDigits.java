package com.bharath.skills.main;
import java.util.LinkedList;

class RemoveKSolution {

    public String removeKdigits(String num, int k) {

        LinkedList<Character> st = new LinkedList<>();

        for(char c: num.toCharArray()){

            while(!st.isEmpty() && k > 0 && st.peek() > c){
                st.pop();
                k--;
            }

            st.push(c);
        }

        while(k-->0){
            st.pop();
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty())
            sb.append(st.removeLast());

        System.out.println(sb);

        int i = 0;

        while(i < sb.length() && sb.charAt(i) == '0')
            sb.deleteCharAt(i);

        return sb.length() == 0? "0":sb.toString();
    }
}

public class RemoveKDigits {

    public static void main(String[] args) {

        RemoveKSolution sol = new RemoveKSolution();

        System.out.println(sol.removeKdigits("10200",1));
    }


}
