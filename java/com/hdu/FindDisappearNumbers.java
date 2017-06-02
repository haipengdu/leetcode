package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hdu on 5/15/17.
 */
public class FindDisappearNumbers {

  public List<Integer> findDisappearedNumbers(int[] nums){
    if ( nums == null || nums.length == 0 )
      return new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    Arrays.sort(nums);
    int previous = 0;
    for(int n : nums){
      if ( n - previous > 1){
        for(int i = previous+1; i < n; i++ )
          result.add(i);
      }
      previous = n;
    }

    if ( previous != nums.length){
      for(int i = previous + 1; i <= nums.length; i++)
        result.add(i);
    }
    return result;
  }
}
