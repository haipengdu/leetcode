package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hdu on 4/18/17.
 */
public class FindIntersections {

  public static void main(String [] args){
    int [] num1 =  {1, 2, 2, 1};
    int [] nums2 = {1, 2, 2};
    CodeUtil.printArray(new FindIntersections().intersection2(num1, nums2));
    CodeUtil.printArray(new FindIntersections().intersection(num1, nums2));
  }

  public int[] intersection(int[] nums1, int[] nums2){
    if (nums1 == null || nums1.length == 0 ||
        nums2 == null || nums2.length == 0){
      return new int[0];
    }

    Set<Integer> firstNums = new HashSet<>();
    for(int i : nums1)
      firstNums.add(i);
    Set<Integer> resultSet = new HashSet<>();
    for(int i : nums2){
      if (firstNums.contains(i))
        resultSet.add(i);
    }

    int [] result = new int[resultSet.size()];
    int index = 0;
    for(int i : resultSet)
      result[index++] = i;
    return result;
  }

  public int[] intersection2(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0 ||
        nums2 == null || nums2.length == 0){
      return new int[0];
    }

    List<Integer> results = new ArrayList<>();

    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int pos1 = 0;
    int pos2 = 0;

    int prev1 = nums1[0];
    int prev2 = nums2[0];

    for( int i =0; i < nums1.length; ){

      while (pos2 < nums2.length && nums2[pos2] < nums1[i])
        pos2++;

      System.out.println(i + " >>>" + pos2);
      if ( pos2 == nums2.length)
        break;

      if (nums2[pos2] == nums1[i]){
        results.add(nums1[i]);
        pos2++;
        while (pos2 < nums2.length && nums2[pos2] == nums2[pos2 - 1])
          pos2++;
      }

      i++;
      while ( i < nums1.length && nums1[i] == nums1[i-1])
        i++;
    }

    int [] resultInt = new int[results.size()];
    for(int i =0; i < results.size(); i++)
      resultInt[i] = results.get(i);
    return resultInt;
  }
}
