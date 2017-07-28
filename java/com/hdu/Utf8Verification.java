package com.hdu;

import java.util.Arrays;

/**
 * Created by hdu on 7/13/17.
 */
public class Utf8Verification {

  public static void main(String[] args) {
    System.out.println(new Utf8Verification().validUtf8(new int[]{235, 140, 4}));
  }

  public boolean validUtf8(int[] data) {
    return validUtf8(data, 0);
  }

  public boolean validUtf8(int[] data, int pos) {
    if ( pos >= data.length )
      return true;

    for(int i = 0; i < 4; i++){
        if ( i + pos >= data.length)
          break;
        int [] nums = new int[i+1];
        System.arraycopy(data, pos, nums,0, nums.length);
        if (!isutf8(nums))
          continue;
        if (validUtf8(data, pos+i+1))
          return true;
    }
    return false;
  }
  private boolean isutf8(int[] nums) {
    if (nums == null || nums.length <= 0 || nums.length > 4)
      return false;
    int utf8N = nums.length;
    String firstNum = toBinary(nums[0]);
    if (nums.length == 1){
      return firstNum.charAt(0) == '0';
    }

    boolean isutf8 = true;
    int pos = 0;
    for(pos = 0; pos < nums.length; pos++)
      isutf8 &= firstNum.charAt(pos) == '1';

    isutf8 &= firstNum.charAt(pos) == '0';

    if (!isutf8)
      return false;

    for(int i =1; i < nums.length; i++){
      if (!toBinary(nums[i]).startsWith("10"))
        return false;
    }
    return true;
  }

  private String toBinary(int num) {
    StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
    int paddingLength = 8 - sb.length();
    for (int i = 0; i < paddingLength; i++) {
      sb.insert(0, "0");
    }
    return sb.toString();
  }
}
