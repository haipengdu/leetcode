package com.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdu on 5/16/17.
 */
public class FindTitBT {

  int tilt = 0;
  public int findTilt(TreeNode root) {
    postorder(root);
    return tilt;
  }

  public int postorder(TreeNode root) {
    if (root == null) return 0;
    int leftSum = postorder(root.left);
    int rightSum = postorder(root.right);
    tilt += Math.abs(leftSum - rightSum);
    return leftSum + rightSum + root.val;
  }

  public int findBottomLeftValue(TreeNode root) {
    Map<Integer, List<Integer>> levelValues = new HashMap<>();
    travelWithLevel(root, 0, levelValues);
    int max = Integer.MIN_VALUE;
    for(int level : levelValues.keySet()){
      if (level > max)
        max = level;
    }
    return levelValues.get(max).get(0);
  }

  private void travelWithLevel(TreeNode node, int level, Map<Integer, List<Integer>> levelValues){
    if ( node == null )
      return ;

    travelWithLevel(node.left, level + 1, levelValues);
    List<Integer> values = levelValues.getOrDefault(level, new ArrayList<>());
    values.add(node.val);
    levelValues.put(level, values);
    travelWithLevel(node.right, level + 1, levelValues);
  }
}
