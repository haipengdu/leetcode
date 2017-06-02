package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hdu on 4/17/17.
 */
public class FindDisappearedNumbers {

  public static void main(String [] args){
    int [] nums = new int[]{1,1};

    CodeUtil.printObject(new FindDisappearedNumbers().findDisappearedNumbers(nums));
  }
  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null || nums.length == 0 ){
      return new ArrayList<>();
    }

    Arrays.sort(nums);
    List<Integer> result = new ArrayList<>();
    int previous = 0;
    for(int i =0; i < nums.length; i++){
      if ( nums[i] - previous > 1){
        for(int num = previous + 1; num < nums[i]; num++)
          result.add(num);
      }
      previous = nums[i];
    }

    if (nums[nums.length - 1] < nums.length){
      for(int num = nums[nums.length - 1] + 1; num <= nums.length; num++)
        result.add(num);
    }
    return result;
  }

}
