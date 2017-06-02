package com.hdu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hdu on 5/18/17.
 */
public class IsSameBST {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if ( p == null && q == null)
      return true;
    if (p == null || q == null)
      return false;
    if (p.val != q.val)
      return false;

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0)
      return -1;
    if (nums.length <= 2)
      return nums[0];
    Arrays.sort(nums);
    return nums[nums.length/2];
  }

  public int majorityElement2(int [] nums){
    if (nums == null || nums.length == 0)
      return -1;
    if (nums.length <= 2)
      return nums[0];
    Map<Integer, Integer> counts = new HashMap<>();
    for(int n : nums){
      int count = counts.getOrDefault(n, 0) + 1;
      if ( count > nums.length / 2)
        return n;
      counts.put(n, count);
    }
    return -1;
  }

  public boolean isAnagram(String s, String t) {
    if (s == null || t == null )
      return false;
    if (s.length() != t.length())
      return false;

    int [] chars = new int[26];

    for(int i =0; i < s.length(); i++){
      chars[s.charAt(i) - 'a']++;
    }
    for(int i =0; i < t.length(); i++){

      chars[t.charAt(i) - 'a']--;
      if ( chars[t.charAt(i) - 'a'] < 0)
        return false;
    }

    return true;
  }
}
