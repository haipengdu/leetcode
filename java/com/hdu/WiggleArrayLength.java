package com.hdu;

import java.math.BigInteger;

/**
 * Created by hdu on 7/17/17.
 */
public class WiggleArrayLength {

  public static void main(String [] args){
    new WiggleArrayLength().wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8});
  }
  public int wiggleMaxLength(int[] nums) {

    if( nums.length == 0 ) return 0;

    int[] up = new int[nums.length];
    int[] down = new int[nums.length];

    up[0] = 1;
    down[0] = 1;

    for(int i = 1 ; i < nums.length; i++){
      if( nums[i] > nums[i-1] ){
        up[i] = down[i-1]+1;
        down[i] = down[i-1];
      }else if( nums[i] < nums[i-1]){
        down[i] = up[i-1]+1;
        up[i] = up[i-1];
      }else{
        down[i] = down[i-1];
        up[i] = up[i-1];
      }
    }

    CodeUtil.printArray(nums);
    CodeUtil.printArray(up);
    CodeUtil.printArray(down);

    return Math.max(down[nums.length-1],up[nums.length-1]);
  }

  public boolean isAdditiveNumber(String num) {
    int n = num.length();
    for (int i = 1; i <= n / 2; ++i) {
      if (num.charAt(0) == '0' && i > 1) return false;
      BigInteger x1 = new BigInteger(num.substring(0, i));
      for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
        if (num.charAt(i) == '0' && j > 1) break;
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        if (isValid(x1, x2, j + i, num)) return true;
      }
    }
    return false;
  }
  private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
    if (start == num.length()) return true;
    x2 = x2.add(x1);
    x1 = x2.subtract(x1);
    String sum = x2.toString();
    return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
  }
}
