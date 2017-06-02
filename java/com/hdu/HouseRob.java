package com.hdu;

/**
 * Created by hdu on 5/22/17.
 */
public class HouseRob {

  public int rob(int[] nums) {

    if ( nums == null || nums.length == 0)
      return 0;
    if ( nums.length == 1 )
      return nums[0];

    int preYes = nums[0];
    int preNo = 0;

    for( int i =1; i < nums.length; i++){
      int tmp = preNo;
      preNo = Math.max(preNo, preYes);
      preYes = nums[i] + tmp;
    }
    return Math.max(preNo, preYes);
  }
}
