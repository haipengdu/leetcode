package com.hdu;

import java.util.Stack;

/**
 * Created by hdu on 8/4/17.
 */
public class FindNearestSmaller {

  public static void main(String [] args){
    CodeUtil.printArray(new FindNearestSmaller().findNearestSmaller(new int[] {3, 5, 2, 6, 9, 7, 10}));
  }
  public int [] findNearestSmaller(int [] numbers){
    if ( numbers == null || numbers.length == 0 ){
      return new int[0];
    }
    int [] result = new int[numbers.length];
    Stack<Integer> increasingStack = new Stack<>();

    for(int i =0; i < numbers.length; i++){
      while(!increasingStack.isEmpty() && increasingStack.peek() >= numbers[i]){
        increasingStack.pop();
      }
      if (increasingStack.isEmpty()){
        result[i] = numbers[i];
      }else {
        result[i] = increasingStack.peek();
      }
      increasingStack.push(numbers[i]);
    }

    return result;
  }
}
