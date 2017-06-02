package com.hdu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hdu on 5/29/17.
 */
public class FindDuplication {

  public  static void main(String []args){
    CodeUtil.printObject(new FindDuplication().findPairs(new int [] {3,1,4,1,5}, 2));
  }
  public boolean containsNearbyDuplicate(int[] nums, int k){
    if ( nums == null || nums.length == 0 )
      return false;
    Set<Integer> data = new HashSet<>();
    for(int i =0; i < nums.length; i++){
      if ( i > k )
        data.remove(nums[i -k -1]);
      if ( data.contains(nums[i]))
        return true;
      data.add(nums[i]);
    }
    return false;
  }

  public int findNthDigit(int n) {
    int num = n -1;
    int first = 1, digits = 1;
    int count = 9;
    while ( num / count > 0){
      num -= count;
    }
    return (first + num/digits + "").charAt(num%digits) - '0';
  }


  public int findUnsortedSubarray(int[] A) {
    int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
    for (int i=1;i<n;i++) {
      max = Math.max(max, A[i]);
      min = Math.min(min, A[n-1-i]);
      if (A[i] < max) end = i;
      if (A[n-1-i] > min) beg = n-1-i;
    }
    return end - beg + 1;
  }

  public int findPairs(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0)
      return 0;
    Map<Integer, Integer> counts = new HashMap<>();
    int count = 0;
    for(int n : nums){
      counts.put(n, counts.getOrDefault(n, 0) + 1);
    }

    for(int n : counts.keySet()){
      if ( k == 0 ){
        if ( counts.get(n) > 1)
          count++;

      }else if (counts.get(n+k) != null)
        count++;
    }
    return count;
  }

  }
