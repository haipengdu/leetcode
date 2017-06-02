package com.hdu;

/**
 * Created by hdu on 5/6/17.
 */
public class KthSmallestBST {


  public static void main(String [] args){
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.right = new TreeNode(2);

    CodeUtil.printObject(new KthSmallestBST().kthSmallest(root, 3));
  }

  public int kthSmallest(TreeNode node, int k){
    int [] kthStatus = kthSmallest(node, k, 0);
    return kthStatus[1];
  }
  public int[] kthSmallest(TreeNode node, int k, int countBefore){
    if (node == null ){
      return new int[] {0, Integer.MAX_VALUE};
    }
    int[] leftStatus = kthSmallest(node.left, k, countBefore);
    if (leftStatus[1] < Integer.MAX_VALUE)
      return leftStatus;

    int currentCount = leftStatus[0] + countBefore + 1;
    if ( k == currentCount ){
      return new int [] {k, node.val};
    }
    int[] rightStatus = kthSmallest(node.right, k, currentCount);
    return new int[]{ leftStatus[0] + rightStatus[0] + 1, Math.min(rightStatus[1], Integer.MAX_VALUE)};
  }
}
