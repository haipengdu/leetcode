package com.hdu;

/**
 * Created by hdu on 6/6/17.
 */
public class BSTCodec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String [] items = data.split(",");
    TreeNode root  = null;
    for(String item : items){
      int val = Integer.valueOf(item);
      root = buildBst(root, val);
    }
    return root;
  }

  private TreeNode buildBst(TreeNode root, int val) {
    if ( root == null ){
      root = new TreeNode(val);
      return root;
    }

    if ( root.val > val)
      root.left = buildBst(root.left, val);
    else
      root.right = buildBst(root.right, val);
    return root;
  }

  private void serialize(TreeNode root, StringBuilder builder){
    if ( root == null )
      return;
    if ( builder.length() > 0)
      builder.append(",");
    builder.append(root.val);
    serialize(root.left, builder);
    serialize(root.right, builder);
  }
}
