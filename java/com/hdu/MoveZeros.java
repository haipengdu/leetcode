package com.hdu;

/**
 * Created by hdu on 4/17/17.
 */
public class MoveZeros {

  public static void main(String [] args){
    int[] nums = new int[]{0, 1, 0, 3, 12};
    new MoveZeros().moveZeroes(nums);
    CodeUtil.printArray(nums);
  }
  public void moveZeroes(int[] nums) {

    if ( nums == null || nums.length == 0 ){
      return;
    }

    int numOfZeros = 0;
    for(int i =0; i < nums.length; i++){
      if (nums[i] == 0){
        numOfZeros++;
      }else if (i - numOfZeros != i){
        nums[i - numOfZeros] = nums[i];
      }
    }

    for(int i =0; i < numOfZeros; i++){
      nums[nums.length -  1 - i] = 0;
    }
  }
}
