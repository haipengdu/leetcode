package com.hdu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hdu on 4/18/17.
 */
public class FindRelativeRanks {

  public static void main(String [] args){
    int [] nums = {10, 8, 12, 3, 6};
    nums = new int [] {5,4,3,2,1};
   // CodeUtil.printArray(new FindRelativeRanks().findRelativeRanks2(nums));
    CodeUtil.printArray(new FindRelativeRanks().findRelativeRanks(nums));
  }
  public String[] findRelativeRanks2(int[] nums) {

    if (nums == null || nums.length == 0 ){
      return new String[] {};
    }

    String [] medals = new String [] {"Gold Medal", "Silver Medal", "Bronze Medal"};
    String [] result = new String[nums.length];

    Map<Integer, Integer> positions = new HashMap<>();

    for(int i =0; i < nums.length; i++){
      positions.put(nums[i], i);
    }
    System.out.println(positions);
    Arrays.sort(nums);


    for(int i =0; i < nums.length; i++){
      int pos = positions.get(nums[i]);
      int rank = nums.length - i - 1;
      if (rank < 3)
        result[pos] = medals[rank];
      else
        result[pos] = "" + (rank+1);
    }
    return result;
  }

  public String[] findRelativeRanks(int[] nums) {
    if ( nums == null || nums.length == 0)
      return new String[0];
    String[] medals = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
    String [] result = new String[nums.length];

    Map<Integer, Integer> map = new HashMap<>();
    for(int i =0; i < nums.length; i++)
      map.put(nums[i], i);

    Arrays.sort(nums);

    for(int i = nums.length - 1; i >= 0; i--){
      int pos = nums.length - 1 - i;
      String rank = null;
      if ( pos < 3)
        rank = medals[pos];
      else
        rank = "" + (pos + 1);
      int index = map.get(nums[i]);

      result[index] = rank;
    }
    return result;
  }
}
