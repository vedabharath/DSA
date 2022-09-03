package com.bharath.skills.main;

import java.util.Arrays;

class SmallestInfiniteSet {
    
    
    boolean[] map = new boolean[1001];
    
    int in = 1;
        

    public SmallestInfiniteSet() {
        
        Arrays.fill(map,true);
        in = 1;
        
    }
    
    public int popSmallest() {
        
        while(map[in] == false) in++;
        
        map[in++] = false;
        
        return in-1;
        
    }
    
    public void addBack(int num) {
        
        if(!map[num]){
            map[num] = true;
            if(in > num) in = num;
        }
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */