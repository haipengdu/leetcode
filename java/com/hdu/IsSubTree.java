package com.hdu;

/**
 * Created by hdu on 5/21/17.
 */
public class IsSubTree {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if ( s == null && t == null )
      return true;
    if (s == null || t == null )
      return false;
    if ( s == t )
      return true;
    return isSameTree(s, t) || isSubtree(s.left, t) ||  isSubtree(s.right, t);
  }

  public boolean isSameTree(TreeNode node1, TreeNode node2){
    if ( node1 == null && node2 == null)
      return true;
    if (node1 == null || node2 == null)
      return false;
    if (node1.val != node2.val)
      return false;
    return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
  }
}
