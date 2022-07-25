package com.bharath.skills.defs;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    public List<NestedInteger> list;

    public Integer integer;

    // Constructor initializes an empty nested list.
    public NestedInteger(){

        list = new ArrayList<>();

    }

    //Constructor initializes a single integer.
    public NestedInteger(int value){

        this.integer = value;

    }

    public boolean isInteger() {

        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(int value) {
        this.integer = value;

    }
    public void add(NestedInteger ni) {

        if(list == null) list = new ArrayList<>();
        list.add(ni);

    }
    public List<NestedInteger> getList() {
        return list;
    }
}
