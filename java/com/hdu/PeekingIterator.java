package com.hdu;

import java.util.Iterator;

/**
 * Created by hdu on 7/12/17.
 */
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer peekNumber;

    public PeekingIterator(Iterator<Integer> iterator) {
      this.iterator = iterator;
      if ( this.iterator.hasNext())
        peekNumber = this.iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
      return peekNumber;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
      Integer result = peekNumber;
      if (this.iterator.hasNext())
        peekNumber = this.iterator.next();
      else
        peekNumber = null;
      return result;
    }

    @Override
    public boolean hasNext() {
      return iterator.hasNext() || peekNumber != null;
    }

  public boolean makesquare(int[] nums) {
    return false;
  }
}
