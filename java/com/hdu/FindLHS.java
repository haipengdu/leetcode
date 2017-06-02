package com.hdu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hdu on 5/24/17.
 */
public class FindLHS {

  public static void main(String [] args){
    CodeUtil.printObject(new FindLHS().findLHS(new int[] {1,1,1,1}));
  }
  public int findLHS(int[] nums) {

    if ( nums == null || nums.length == 0)
      return 0;

    Map<Integer, Integer> counts = new HashMap<>();
    for(int i : nums){
      int count = counts.getOrDefault(i, 0) + 1;
      counts.put(i, count);
    }


    int max = 0;

    for(int n : counts.keySet()){
      int currentCount = counts.get(n);
      int lowCount = counts.getOrDefault(n-1, Integer.MIN_VALUE);
      int highCount = counts.getOrDefault(n+1, Integer.MIN_VALUE);
      int currentMax = Math.max(lowCount, highCount) + currentCount;
      max = Math.max(max, currentMax);
    }

    return max;
  }

  public int maxSubArray(int[] nums){
    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];

    for(int i =1; i < nums.length; i++){
      maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
      maxSoFar=Math.max(maxSoFar, maxEndingHere);
    }

    return Math.max(maxSoFar, maxEndingHere);
  }
}
