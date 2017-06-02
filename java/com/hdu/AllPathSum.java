package com.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdu on 5/27/17.
 */
public class AllPathSum {

  Map<Integer, Integer> allValues = new HashMap<>();
  public int pathSum(TreeNode root, int sum) {
    return 0;
  }

  public void allPathSum(TreeNode node, List<Integer> traveledSums){

    if ( node == null)
      return;
    allValues.put(node.val, allValues.getOrDefault(node.val, 0) + 1);

    List<Integer> pathValues = new ArrayList<>();
    pathValues.add(node.val);

    for(Integer val : traveledSums){
      int total = val + node.val;
      allValues.put(total, allValues.getOrDefault(total, 0) + 1);
      pathValues.add(total);
    }

    allPathSum(node.left,  pathValues);
    allPathSum(node.right, pathValues);
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return buildWithIndex(nums, 0, nums.length -1);
  }

  public TreeNode buildWithIndex(int [] nums, int low, int high){
    if ( low > high)
      return null;
    int rootIndex = (low+high) / 2;
    TreeNode root = new TreeNode(nums[rootIndex]);
    root.left = buildWithIndex(nums, low, rootIndex -1);
    root.right = buildWithIndex(nums, rootIndex+1, high);
    return root;
  }

  public int searchInsert(int[] a, int target) {
    if ( a == null || a.length == 0 )
      return 0;
    int low = 0; int high = a.length - 1;
    while(low <= high){
      int middle = (low+high)/2;
      if ( a[middle] == target)
        return middle;
      else if (target > a[middle])
        low = middle + 1;
      else high = middle - 1;
    }
    return low;
  }
}
