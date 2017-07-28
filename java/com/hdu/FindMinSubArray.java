package com.hdu;

import java.util.Stack;

/**
 * Created by hdu on 6/24/17.
 */
public class FindMinSubArray {
  public static void main(String [] args){
    CodeUtil.printObject(new FindMinSubArray().minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
  }
  public int minSubArrayLen(int s, int [] nums){
    if ( nums == null || nums.length == 0 )
      return 0;

    int start = 0;
    int current = 0;
    int min = Integer.MAX_VALUE;
    int sum = 0;
    while( current < nums.length){
      if (nums[current] >= s)
        return 1;
      sum += nums[current];
      while ( sum >= s && start < nums.length){
        min = Math.min(min, current - start + 1);
        sum -= nums[start];
        start++;
      }

      current++;
    }

    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public boolean find132pattern(int[] nums) {
    if ( nums == null || nums.length < 3)
      return false;
    Stack<Integer> stack = new Stack<>();
    int sk = Integer.MIN_VALUE;
    for(int i = nums.length - 1; i >= 0; i--){
      if (nums[i] < sk) return true;
      else{
        //find the min sk in the stack
        while (!stack.empty() && nums[i] > stack.peek()){
          sk = stack.pop();
        }
        stack.push(nums[i]);
      }
    }
    return true;
  }
}
