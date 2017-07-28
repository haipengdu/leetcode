package com.hdu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hdu on 6/7/17.
 */
public class BSTIterator {

  Queue<Integer> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
      pushData(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
      return queue.poll();
    }

    private void pushData(TreeNode root){
      if ( root == null )
        return;
      pushData(root.left);
      queue.offer(root.val);
      pushData(root.right);
    }

}
