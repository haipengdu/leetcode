package com.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdu on 4/23/17.
 */
public class LevelOrderBottom {

  public static void  main(String [] args){
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.right = new TreeNode(16);
    CodeUtil.printObject(new LevelOrderBottom().levelOrderBottom(root));
  }
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    Map<Integer, List<Integer>> mapResult = new HashMap<>();
    int maxLevel = travelTrees(root, 0, mapResult);
    List<List<Integer>> result = new ArrayList<>();

    for(int i = maxLevel -1; i>= 0; i--){
      result.add(mapResult.get(i));
    }
    return result;
  }

  private int travelTrees(TreeNode node, int level, Map<Integer, List<Integer>> result){
    if (node == null )
      return 0;
    List<Integer> levelData = result.getOrDefault(level, new ArrayList<>());
    levelData.add(node.val);
    result.put(level, levelData);

    int levelLeft = travelTrees(node.left, level + 1, result);
    int levelRight = travelTrees(node.right, level + 1, result);
    return Math.max(levelLeft, levelRight) + 1;
  }

  public List<Integer> largestValues(TreeNode root) {

    Map<Integer, Integer> levelMax = new HashMap<>();
    int maxLevel = travelTrees2(root, 0, levelMax);
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i <= maxLevel; i++){
      if (levelMax.get(i) != null)
        result.add(levelMax.get(i));
    }
    return result;
  }

  private int travelTrees2(TreeNode node, int level, Map<Integer, Integer> levelMax){
    if (node == null )
      return 0;
    Integer max = levelMax.get(level);
    if ( max == null || max < node.val)
      levelMax.put(level, node.val);

    int levelLeft = travelTrees2(node.left, level + 1, levelMax);
    int levelRight = travelTrees2(node.right, level + 1, levelMax);
    return Math.max(levelLeft, levelRight) + 1;
  }

  public TreeNode convertBST(TreeNode root) {
    travelWithAllGreater(root, 0);
    return root;
  }

  private int travelWithAllGreater(TreeNode node, int preTotal){
    if ( node == null )
      return 0;

    int rightTotal = travelWithAllGreater(node.right, 0);
    node.val = node.val + rightTotal + preTotal;
    int leftTotal = travelWithAllGreater(node.left, node.val);

    return node.val + leftTotal;
  }

  int sum = 0;

  public TreeNode convertBST2(TreeNode root) {
    convert(root);
    return root;
  }

  public void convert(TreeNode cur) {
    if (cur == null) return;
    convert(cur.right);
    cur.val += sum;
    sum = cur.val;
    convert(cur.left);
  }
}
