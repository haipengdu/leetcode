package com.hdu;

/**
 * Created by hdu on 4/18/17.
 */
public class TwoSum {

  public static void main(String [] args){
    int [] nums = {2, 3, 7, 11, 15};
    CodeUtil.printArray(new TwoSum().twoSum2(nums, 9));
    CodeUtil.printArray(new TwoSum().twoSum(nums, 9));
  }
  public int[] twoSum2(int[] num, int target){
    int [] result = new int []{-1,-1};
    int low = 0;
    int high = num.length -1;
    while( low < high && num[low] + num[high] != target){
      if (num[low] + num[high] > target)
        high--;
      else
        low++;
    }
    if (num[low] + num[high] == target){
      result[0] = low;
      result[1] = high;
    }
    return result;
  }




  public int [] twoSum(int [] nums, int target){
    int [] result = new int [] {-1, -1};
    int high = nums.length -1;
    int low = 0;

    while (low < high && nums[low] + nums[high] != target){
      int total = nums[low] + nums[high];
      if ( total > target )
        high--;
      else
        low++;
    }

    if ( nums[low] + nums[high] == target){
      result[0] = low ;
      result[1] = high;
    }
    return result;
  }
}
