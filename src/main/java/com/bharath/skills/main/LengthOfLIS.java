package com.bharath.skills.main;

import java.util.Arrays;

class Seg{
    
    int n;
    int[] t;
    
    public Seg(int n){
        this.n = n;
        t = new int[2*n];
    }
    
    public int query(int l, int r){
        
        l+=n;
        r+=n;
        
        int max = 0;
        
        while(l < r){
            
            if(l%2 == 1){
                max= Math.max(max,t[l]);
                l++;
            }
            
            if(r%2 == 1){
                r--;
                max = Math.max(max,t[r]);
            }
            
            l >>=1;
            r >>=1;
        }
        
        return max;
        
    }
    
    public void update(int p, int val){
        
        p+=n;
        
        t[p] = val;
        
        while(p > 1){
            p>>=1;
            t[p] = Math.max(t[2*p+1],t[2*p]);
        }
        
    }
}

public class LengthOfLIS {
    
    public int lengthOfLIS(int[] nums, int k) {
                
        int n = Arrays.stream(nums).max().getAsInt();
        int max = 1;
        Seg t = new Seg(n);
        
        for(int a: nums){
            a -= 1;
            int premax = t.query(Math.max(0,a-k),a);
            max = Math.max(max,premax+1);
            t.update(a,premax+1);
           
            
        }
        
        return max;
         
        
    }
}