package com.hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hdu on 6/27/17.
 */
public class FindMinHeightOfTree {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) return Collections.singletonList(0);
    List<Integer> leaves = new ArrayList<>();
    List<Set<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
    for (int i = 0; i < n; ++i) {
      if (adj.get(i).size() == 1) leaves.add(i);
    }
    while (n > 2) {
      n -= leaves.size();
      List<Integer> newLeaves = new ArrayList<>();
      for (int i : leaves) {
        int t = adj.get(i).iterator().next();
        adj.get(t).remove(i);
        if (adj.get(t).size() == 1) newLeaves.add(t);
      }
      leaves = newLeaves;
    }
    return leaves;
  }
}
