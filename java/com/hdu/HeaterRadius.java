package com.hdu;

import java.util.Arrays;

/**
 * Created by hdu on 5/29/17.
 */
public class HeaterRadius {

  public static void main(String [] args){
    //CodeUtil.printObject(new HeaterRadius().findRadius(new int[] {1,2,3,4}, new int[] {1,2,3,4}));
    CodeUtil.printObject(new HeaterRadius().thirdMax(new int [] {1,2,Integer.MIN_VALUE}));
  }
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int redius = 0, heaterPos = 0;
    for(int house : houses){
      while ( heaterPos < heaters.length - 1 && Math.abs(heaters[heaterPos+1] - house) < Math.abs(heaters[heaterPos] - house))
        heaterPos++;
      redius = Math.max(redius, Math.abs(heaters[heaterPos] - house));
    }
    return redius;
  }


  public int thirdMax(int[] nums){
    if (nums == null || nums.length == 0 )
      return 0;
    int [] m = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    int maxIndex = 0;
    for(int n : nums){
      for(int i =0; i < 3; i++){
        if ( n == m[i])
          break;
        if ( n < m[i])
          continue;
        int tmp = m[i];
        m[i] = n;
        n = tmp;
        maxIndex = Math.max(maxIndex, i);
      }
    }

    return maxIndex < 2 ? m[0] : m[2];
  }

  }
