package com.hdu;

/**
 * Created by hdu on 4/23/17.
 */
public class SearchIndex {
  public int searchInsert(int[] nums, int target) {

    if ( nums == null || nums.length == 0 )
      return 0;
    return searchIndexBinary(nums, 0, nums.length - 1, target);
  }

  public int searchIndexBinary(int[]  nums, int low, int high, int target){

    int middle = low/2 + high/2;
    if (nums[middle] == target)
      return middle;
    if (high == low + 1){
      if (nums[high] > target)
        return high + 1;
      return high;
    }
    if (high == low){
      if (nums[high] > target)
        return high;
      return high + 1;
    }
    if (nums[middle] > target)
      return searchIndexBinary(nums, low, middle - 1, target);
    return searchIndexBinary(nums, middle+1, high, target);
  }
}
