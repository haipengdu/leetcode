package com.hdu;

/**
 * Created by hdu on 5/15/17.
 */
public class InvertTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    invertTree(root.left);
    invertTree(root.right);
    return root;
  }
}
