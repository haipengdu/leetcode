package com.hdu;

/**
 * Created by hdu on 4/17/17.
 */
public class FindMaxConsecutiveOnes {

  public static void main(String [] args){
    int [] nums = new int[]{1,1,0,1,1,1};
  CodeUtil.printObject(new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    CodeUtil.printObject(new FindMaxConsecutiveOnes().findMaxConsecutiveOnes2(nums));
  }

  public int findMaxConsecutiveOnes2(int[] nums) {

    if (nums == null || nums.length == 0 )
      return 0;

    int maxOnes = 0;
    int currentOnes = 0;
    for(int i =0; i < nums.length; i++){
      if (nums[i] == 1 )
        currentOnes++;
      else {
        if (currentOnes > maxOnes)
          maxOnes = currentOnes;
        currentOnes = 0;
      }
    }
    if (currentOnes > maxOnes)
      maxOnes = currentOnes;
    return maxOnes;
  }

  public int findMaxConsecutiveOnes(int[] nums) {
    if ( nums == null || nums.length == 0 ){
      return 0;
    }
    int maxOnes = 0;
    int currentOnes = 0;
    for(int i : nums){
      if (i == 0 ){
        if ( currentOnes > maxOnes)
          maxOnes = currentOnes;
        currentOnes = 0;
      }else{
        currentOnes++;
      }
    }

    if ( currentOnes > maxOnes)
      maxOnes = currentOnes;
    return maxOnes;
  }
}
