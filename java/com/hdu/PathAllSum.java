package com.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdu on 4/23/17.
 */
public class PathAllSum {
  Map<Integer, Integer> allValues = new HashMap<>();

  public int pathSum(TreeNode root, int sum) {
    allPathSum(root, new ArrayList<>());
    return allValues.getOrDefault(sum, 0);
  }

  public void allPathSum(TreeNode node, List<Integer> traveledSums){
    if (node == null)
      return ;

    allValues.put(node.val, allValues.getOrDefault(node.val,0) + 1);

    List<Integer> pathValues = new ArrayList<>();
    pathValues.add(node.val);

    for(int traveledSum : traveledSums){
      int pathValue = node.val + traveledSum;
      allValues.put(pathValue, allValues.getOrDefault(pathValue,0) + 1);
      pathValues.add(pathValue);
    }

    allPathSum(node.left,  pathValues);
    allPathSum(node.right, pathValues);

  }
}
