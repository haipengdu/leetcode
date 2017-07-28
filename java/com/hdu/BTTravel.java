package com.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by hdu on 6/6/17.
 */
public class BTTravel {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if ( root == null )
      return result;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    stack.push(node);
    while (!stack.empty()){
      node = stack.pop();
      result.add(node.val);
      if ( node.right != null )
        stack.push(node.right);
      if (node.left != null)
        stack.push(node.left);
    }
    return result;
  }
}
