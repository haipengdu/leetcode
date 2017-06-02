package com.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hdu on 4/17/17.
 */
public class FindIntersectionsWithDuplicate {

  public static void main(String [] args){
    int [] num1 =  {1, 2, 2, 1};
    int [] nums2 = {1, 2, 2};
    CodeUtil.printArray(new FindIntersectionsWithDuplicate().intersect(num1, nums2));
  }
  //TODO work on it
  public int[] intersect(int[] nums1, int[] nums2) {
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

    for( int i =0; i < nums1.length && pos2 < nums2.length;  ){

      while (pos2 < nums2.length && nums2[pos2] < nums1[i])
        pos2++;

      if ( pos2 == nums2.length)
        break;

      if (nums2[pos2] == nums1[i]) {
        while (pos2 < nums2.length && i < nums1.length && nums2[pos2] == nums1[i]) {
          results.add(nums1[i]);
          pos2++;
          i++;
        }
      }else{
        i++;
      }


    }

    int [] resultInt = new int[results.size()];
    for(int i =0; i < results.size(); i++)
      resultInt[i] = results.get(i);
    return resultInt;
  }
}
