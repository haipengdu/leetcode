package com.hdu;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by hdu on 8/6/17.
 */
public class TrapRagingWater {

  public static void main(String [] args){
    CodeUtil.printObject(new TrapRagingWater().trap(new int [] {0,1,0,2,1,0,1,3,2,1,2,1}));
  }
  public int trap(int[] A) {
    if (A==null) return 0;
    Stack<Integer> s = new Stack<Integer>();
    int i = 0, maxWater = 0, maxBotWater = 0;
    while (i < A.length){
      if (s.isEmpty() || A[i]<=A[s.peek()]){
        s.push(i++);
      }
      else {

        int bot = s.pop();

        maxBotWater = s.isEmpty()? // empty means no il
            0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);

        System.out.println(i + " " + bot + " " + maxBotWater + " " + Arrays.toString(s.toArray()));
        maxWater += maxBotWater;
      }
    }
    return maxWater;
  }

}
