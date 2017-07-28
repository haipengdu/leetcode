package com.hdu;

/**
 * Created by hdu on 6/26/17.
 */
public class CopyRandomPointList {
  public RandomListNode copyRandomList(RandomListNode head) {
    if ( head == null )
      return null;

    RandomListNode node = head;
    while(node != null){
      RandomListNode newNode = new RandomListNode(node.label);
      newNode.next = node.next;
      node.next = newNode;
      node = newNode.next;
    }

   node = head;
    while(node != null){
      node.next.random = node.random.next;
      node = node.next.next;
    }

    RandomListNode newHead = head.next;
    node = head;
    RandomListNode newNode = newHead;

    while(node != null){
      node.next = newNode.next;
      newNode.next = node.next.next;
    }
    return newHead;
  }
}
