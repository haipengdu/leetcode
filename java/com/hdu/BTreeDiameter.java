package com.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdu on 4/21/17.
 */
public class BTreeDiameter {

  public static void main(String [] args){
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(7);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    CodeUtil.printObject(new BTreeDiameter().diameterOfBinaryTree(root));

  }
  int max = 0;
  public int diameterOfBinaryTree(TreeNode root) {
     diameterOfBinaryTreeInternal(root);
    return max;
  }

  private int diameterOfBinaryTreeInternal(TreeNode root) {
    if (root == null)
      return 0;
    int leftDepth = diameterOfBinaryTreeInternal(root.left);
    int rightDepth = diameterOfBinaryTreeInternal(root.right);
    max = Math.max(leftDepth + rightDepth, max);
    return Math.max(leftDepth , rightDepth) + 1 ;
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    binaryTreePaths(root, paths, "");
    return paths;
  }

  public void  binaryTreePaths(TreeNode root, List<String> paths, String path){
    if (root == null ){
      return ;
    }

    if ( path.length() > 0)
      path += "->";
    path += root.val;

    if ( root.left == null && root.right == null){
      paths.add(path);
      return;
    }
    binaryTreePaths(root.left, paths, path);
    binaryTreePaths(root.right, paths, path);

  }

  public boolean hasPathSum(TreeNode root, int sum) {
    return pathSum(root, sum, 0);
  }
  public boolean pathSum(TreeNode root, int target, int preSum){
    if ( root == null )
      return false;
    if (root.left == null && root.right == null ) {
      return preSum + root.val == target;
    }
    return pathSum(root.left, target, preSum+root.val) ||
           pathSum(root.right, target, preSum+root.val);
  }

  public boolean isIsomorphic(String s, String t) {
    if ( s == null || t == null || s.length() != t.length() )
      return false;
    return onePass(s, t) && onePass(t, s);
  }


  public boolean onePass(String s, String t)
  {
    java.util.HashMap<Character, Character> map = new java.util.HashMap<Character, Character>();
    for(int i = 0; i < s.length(); i++)
    {
      char cs = s.charAt(i);
      char ct = t.charAt(i);
      if(!map.containsKey(cs)){
        map.put(cs, ct);
      }else{
        if(map.get(cs) != ct)
          return false;
      }
    }
    return true;
  }
}
