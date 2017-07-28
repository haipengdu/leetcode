package com.hdu;

import java.util.PriorityQueue;

/**
 * Created by hdu on 7/9/17.
 */
public class MergeListNode {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0)
      return null;
    if (lists.length == 1 )
      return lists[0];


    PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
    for(ListNode node : lists){
      if (node == null)
        continue;
      queue.offer(node);
    }

    ListNode root = new ListNode(0);
    ListNode node = root;

    while(!queue.isEmpty()){

      node.next = queue.poll();
      ListNode next = node.next.next;
      node = node.next;
      node.next = null;
      if (next != null)
        queue.offer(next);
    }
    return root.next;

  }
}
