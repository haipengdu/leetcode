package com.hdu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hdu on 5/14/17.
 */
public class NextGreaterNumber {

  public int[] nextGreaterElement(int[] findNums, int[] nums) {
    if ( findNums == null || findNums.length == 0 )
      return new int [0];
    Map<Integer, Integer> nextGreaterNumbers = new HashMap<>();
    int [] result = new int [findNums.length];
    for(int i =0; i < nums.length - 1; i++){
      for(int j = i + 1; j < nums.length; j++)
      if ( nums[i] < nums[j]) {
        nextGreaterNumbers.put(nums[i], nums[j]);
        break;
      }
    }

    for(int i =0; i < findNums.length; i++)
      result[i] = nextGreaterNumbers.getOrDefault(findNums[i], -1);
    return result;
  }
}
