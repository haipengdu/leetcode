package com.hdu;

/**
 * Created by hdu on 5/15/17.
 */
public class FindSingleNumber {

  public static void main(String [] args){
    System.out.println( 3 ^ 3);
  }
  public int singleNumber(int[] nums) {
    int num = 0;
    for(int n : nums){
      num ^= n;
    }
    return num;
  }
}
