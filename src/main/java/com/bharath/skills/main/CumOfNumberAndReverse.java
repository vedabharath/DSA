package com.bharath.skills.main;

public class CumOfNumberAndReverse {
    public boolean sumOfNumberAndReverse(int num) {
        
        if(num == 0) return true;
        
        for(int i=1;i<=num;i++){
            
            int a = i;
            
            int b = 0;
            
            while(a > 0){
                b = b*10+a%10;
                a /= 10;
            }
            
            if( i+b == num){
                
                //System.out.println(a+" "+b);
                return true;
                
            } 
            
        }
        
        return false;
        
    }
}