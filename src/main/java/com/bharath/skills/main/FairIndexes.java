package com.bharath.skills.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FairIndexes {

    public static int fairIndex(int a[], int b[]){
        long sumA = 0;
        long sumB = 0;

        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];
        }

        if(sumA != sumB) return 0;

        int count = 0;
        long tempA = 0;
        long tempB = 0;

        for (int i = 1; i < a.length; i++) {
            tempA += a[i];
            tempB += b[i];
            if ( tempA == tempB && 2 * tempA == sumA ) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] A1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(fairIndex(A1, B1));
    }
}
