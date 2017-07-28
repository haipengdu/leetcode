package com.hdu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by hdu on 5/14/17.
 */
public class NextGreaterNumber {

  public static void main(String [] args){
    //[2,3,4,5,6,-1,6,5,6,2,3,4]
    CodeUtil.printArray(new NextGreaterNumber().nextGreaterElements(new int[] {1,2,3,4,5,6,5,4,5,1,2,3}));
  }
  public int[] nextGreaterElement(int[] findNums, int[] nums) {
    if ( findNums == null || findNums.length == 0 )
      return new int [0];
    Map<Integer, Integer> nextGreaterNumbers = new HashMap<>();
    int [] result = new int [findNums.length];
    for(int i =0; i < nums.length - 1; i++){
      for(int j = i + 1; j < nums.length; j++)
      if ( nums[i] < nums[j]) {
        nextGreaterNumbers.put(nums[i], nums[j]);
        break;
      }
    }

    for(int i =0; i < findNums.length; i++)
      result[i] = nextGreaterNumbers.getOrDefault(findNums[i], -1);
    return result;
  }

  public int[] nextGreaterElements(int[] nums) {
      if (nums == null || nums.length == 0)
        return new int[]{};
      if ( nums.length == 1)
        return new int[]{-1};
      int [] result = new int[nums.length];
      int nextGreaterIndex = 1;
      for( int i =0; i < nums.length; i++){
        if (nextGreaterIndex == i)
          nextGreaterIndex = findNextGreaterForward(i, (i+1) % nums.length, nums);
        else {
          if (i == 0)
            nextGreaterIndex = findNextGreaterForward(i, nextGreaterIndex, nums);
          else if (nums[i] > nums[i - 1] && nums[nextGreaterIndex] <= nums[i])
            nextGreaterIndex = findNextGreaterForward(i, nextGreaterIndex, nums);
          else if (nums[i] < nums[i - 1])
            nextGreaterIndex = findNextGreaterForward(i, (i+1) % nums.length, nums);
        }
        if ( nextGreaterIndex == i ) {
          result[i] = -1;
          nextGreaterIndex = (nextGreaterIndex+1) % nums.length;
        }
        else
          result[i] = nums[nextGreaterIndex];

      }
      return result;
  }

  private int findNextGreaterForward(int startPos, int lastNextGreaterIndex, int [] nums) {
    int index= lastNextGreaterIndex;
    while(startPos != index && nums[index] <= nums[startPos]){
      index = (index+1) % nums.length;
    }
    return index;
  }


}
