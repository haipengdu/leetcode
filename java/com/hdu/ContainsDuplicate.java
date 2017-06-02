package com.hdu;

import java.util.Arrays;

/**
 * Created by hdu on 4/19/17.
 */
public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {

    if (nums == null || nums.length < 2)
      return false;
    Arrays.sort(nums);
    for(int i = 1; i < nums.length; i++){
      if (nums[i] == nums[i-1])
        return true;
    }
    return false;
  }
}
