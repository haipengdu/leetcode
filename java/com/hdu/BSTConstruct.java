package com.hdu;

/**
 * Created by hdu on 4/30/17.
 */
public class BSTConstruct {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
  }

  public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0; // Index of current root in inorder
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == root.val) {
        inIndex = i;
      }
    }
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;
  }


  public TreeNode build(int preStart, int inStart, int inEnd, int [] preorder, int [] inorder){
    if (preStart >= preorder.length || inStart >= inEnd)
      return null;
    int val = preorder[preStart];
    TreeNode node = new TreeNode(val);
    int index = 0;
    for( int i = inStart; i <= inEnd; i++){
      if (inorder[i] == val){
        index = i;
        break;
      }
    }
    node.left = build(preStart + 1, inStart, index-1, preorder, inorder);
    node.right = build(preStart+index - inStart + 1, index + 1, inEnd, preorder, inorder);
    return node;
  }
}
