package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StringBreak {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        int count = 0;

        while(in.hasNextLine()){
            String[] tokens = in.nextLine().split("\\s");
            list.addAll(Arrays.asList(tokens));
            String last = tokens[tokens.length - 1];
            if(last.charAt(last.length()-1) == '/') {
                tokens[tokens.length-1] = last.substring(0,last.length()-1);
                continue;
            }
            else break;
        }

        System.out.println(count);

        count  = 0;

        for(String str: list){

            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);

            if(Character.isDigit(first) && Character.isDigit(last)){
                System.out.println(str);
                count++;
            }else if(Character.isDigit(first) && !Character.isDigit(last)){
                System.out.println(str.substring(0,str.length()-1));
                count++;
            }

        }

        System.out.println(count);

        Collections.sort(list);

        System.out.println(list);

    }
}
