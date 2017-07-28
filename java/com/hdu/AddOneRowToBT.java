package com.hdu;

/**
 * Created by hdu on 7/9/17.
 */
public class AddOneRowToBT {

  public TreeNode addOneRow(TreeNode root, int v, int d) {
    return addOneRow(root, v, d, 1);
  }

  public TreeNode addOneRow(TreeNode root, int v, int d, int level) {
      if ( root == null )
        return null;

      if ( d == 1 ){
        TreeNode node = new TreeNode(v);
        node.left = root;
        root = node;
      }
      else if ( level == d -1){
        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;
        root.left = new TreeNode(v);
        root.right = new TreeNode(v);
        root.left.left = oldLeft;
        root.right.right = oldRight;

      }else {
        addOneRow(root.left, v, d, level + 1);
        addOneRow(root.right, v, d, level + 1);
      }
      return root;
  }
}
