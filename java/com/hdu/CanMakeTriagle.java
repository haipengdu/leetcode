package com.hdu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdu on 6/22/17.
 */
public class CanMakeTriagle {

  private int count = 0;

  public static void main(String [] args){
    CodeUtil.printObject(new CanMakeTriagle().triangleNumber(new int[] {2,2,3,4}));
  }
  public int triangleNumber(int[] nums) {
    checkTriangles(nums, 0, new ArrayList<>());
    return count;
  }

  private void checkTriangles(int [] nums, int start, List<Integer> sides){
    if ( sides.size() == 3 ){
      if ( isTriangleSides(sides.get(0), sides.get(1), sides.get(2)))
        count++;
      return;
    }

    for(int i = start; i < nums.length; i++){
      sides.add(nums[i]);
      checkTriangles(nums, i+1, sides);
      sides.remove(sides.size() - 1 );
    }
  }
  public synchronized boolean isTriangleSides(int s1, int s2, int s3){
    return s1 + s2 > s3 &&
           s1 + s3 > s2 &&
           s2 + s3 > s1;
  }
}
