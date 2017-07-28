package com.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdu on 7/13/17.
 */
public class ConnectToNext {
  public void connect(TreeLinkNode root) {
    connect(root, new HashMap<>(), 0);
  }

  public void connect(TreeLinkNode root, Map<Integer, TreeLinkNode> levelNodes, int level) {
    if (root == null )
      return;
    connect(root.right, levelNodes, level+1);
    TreeLinkNode levelode = levelNodes.get(level);
    if (levelode != null && levelode != root){
      root.next = levelode;
    }
    levelNodes.put(level, root);

    connect(root.left, levelNodes, level+1);
  }
}
