package com.hdu;

/**
 * Created by hdu on 4/20/17.
 */
public class FindMissingNumber {

  public static void main(String [] args){
    CodeUtil.printObject(new FindMissingNumber().missingNumber(new int[] {0}));
  }
  public int missingNumber(int[] nums) {
    int n = nums.length ;
    long result = n * (n+1) / 2;

    for( int i =0; i < nums.length; i++)
      result -= nums[i];

    return (int)result;
  }
}
