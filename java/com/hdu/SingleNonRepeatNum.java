package com.hdu;

/**
 * Created by hdu on 5/16/17.
 */
public class SingleNonRepeatNum {

  public int singleNonDuplicate(int[] nums) {
    for(int i = 0; i < nums.length; i+=2){
      if (i == nums.length -1 || nums[i] != nums[i+1])
        return nums[i];
    }
    return -1;
  }

}
