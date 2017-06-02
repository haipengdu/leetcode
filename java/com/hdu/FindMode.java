package com.hdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdu on 4/24/17.
 */
public class FindMode {

  public int[] findMode(TreeNode root) {
    Map<Integer, Integer> occurences = new HashMap<>();
    travelTree(root, occurences);
    int max = 0;
    for(int count : occurences.values()){
      if ( count > max)
        max = count;
    }

    List<Integer> result = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry : occurences.entrySet()){
      if (entry.getValue() == max)
        result.add(entry.getKey());
    }

    int [] intResult = new int[result.size()];
    for(int i =0; i < intResult.length; i++)
      intResult[i] = result.get(i);
    return intResult;
  }

  private void  travelTree(TreeNode node,Map<Integer, Integer> occurences){
    if ( node == null )
      return;
    occurences.put(node.val, occurences.getOrDefault(node.val, 0) + 1);
    travelTree(node.left, occurences);
    travelTree(node.right, occurences);
  }
}
