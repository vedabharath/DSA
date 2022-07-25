package com.bharath.skills.main;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> itr;
    Integer peekedElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        itr = iterator;
        peekedElement = itr.hasNext() ? itr.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peekedElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peekedElement != null) {
            Integer result = peekedElement;
            peekedElement = itr.hasNext() ? itr.next() : null;
            return result;
        }
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        return peekedElement != null;
    }
}
