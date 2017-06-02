package com.hdu;

/**
 * Created by hdu on 4/19/17.
 */
public class SumLeftLeaf {

  public static void  main(String [] args){
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.right = new TreeNode(9);
    root.right.left = new TreeNode(20);

    CodeUtil.printObject(new SumLeftLeaf().sumOfLeftLeaves(root));
  }
  public int sumOfLeftLeaves(TreeNode root) {
    return sumOfLeftLeaves(root, true);
  }


  private int sumOfLeftLeaves(TreeNode node, boolean isLeft){
    if (node == null)
      return 0;
    if (node.left == null && node.right == null){
      return isLeft ? node.val : 0;
    }

    int left = sumOfLeftLeaves(node.left, true);
    int right = sumOfLeftLeaves(node.right, false);
    return left + right;
  }


  public int sumOfLeftLeaves2(TreeNode root) {
    return sumOfLeftLeaves2(root, true);
  }

  private int sumOfLeftLeaves2(TreeNode node, boolean isLeft){
    if (node == null )
      return 0;
    if (node.left == null && node.right == null){
      return isLeft ? node.val : 0;
    }

    int left = sumOfLeftLeaves2(node.left, true);
    int right = sumOfLeftLeaves2(node.right, false);
    return left + right;
  }
}
