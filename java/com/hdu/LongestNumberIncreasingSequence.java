package com.hdu;

/**
 * Created by hdu on 5/8/17.
 */
public class LongestNumberIncreasingSequence {
  public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
      int i = 0, j = size;
      while (i != j) {
        int m = (i + j) / 2;
        if (tails[m] < x)
          i = m + 1;
        else
          j = m;
      }
      tails[i] = x;
      if (i == size) ++size;
    }
    return size;
  }
}
