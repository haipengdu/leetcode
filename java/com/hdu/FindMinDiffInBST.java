package com.hdu;

/**
 * Created by hdu on 4/17/17.
 */
public class FindMinDiffInBST {

  public static void main(String [] args){
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(9);
    CodeUtil.printObject("Diff vv " + new FindMinDiffInBST().getMinimumDifference(root));
    CodeUtil.printTree(root);

  }
  TreeNode previousNode;
  int minDiff = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return minDiff;
  }

  public void inorder(TreeNode node){

    if (node == null ){
      return ;
    }

    inorder(node.left);
    if (previousNode != null ){
      int diff = Math.abs(previousNode.val - node.val);
      if ( diff < minDiff)
        minDiff = diff;
    }
    previousNode = node;
     inorder(node.right);
  }


}
