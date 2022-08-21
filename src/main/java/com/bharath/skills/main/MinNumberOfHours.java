package com.bharath.skills.main;

public class MinNumberOfHours {
    
    public int minNumberOfHours(int a, int b, int[] A, int[] B) {
        
        int t = 0;
        
        for(int i=0;i<A.length;i++){
            
            if(A[i] >= a) {
                t +=  (A[i]-a+1);
                a += (A[i]-a+1);

            }
            a -= A[i];
            if(B[i] >= b){
                t +=  (B[i]-b+1);
                b += (B[i]-b+1);

                
            }
            b += B[i];
        }
        
        return t;
    }

    public static void main(String[] args) {
        MinNumberOfHours sol = new MinNumberOfHours();

        System.out.println( sol.minNumberOfHours(5,3,new int[]{1,4,3,2}, new int[]{2,6,3,1}));
    }
}