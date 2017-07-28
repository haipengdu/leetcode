package com.hdu;

/**
 * Created by hdu on 6/23/17.
 */
public class FlatTree {

  public void flatten(TreeNode root) {
    flattenInternal(root);
  }

  private TreeNode flattenInternal(TreeNode root){
    if ( root == null )
      return null;
    TreeNode newLeft = flattenInternal(root.left);
    TreeNode newRight = flattenInternal(root.right);
    if ( newLeft != null){
      root.right = newLeft;
      TreeNode node = newLeft;
      while(node.right != null)
        node = node.right;
      node.right = newRight;
      root.left = null;
    }
    return root;
  }
}
