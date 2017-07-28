package com.hdu;

/**
 * Created by hdu on 6/27/17.
 */
public class RotateList {

  public static void main(String [] args){
    ListNode root = new ListNode(1);
    ListNode node = root;
    for(int i =2; i < 1; i++){
      node.next = new ListNode(i);
      node = node.next;
    }
    CodeUtil.printList(root);
    CodeUtil.printList(new RotateList().rotateRight(root, 99));
  }
  public ListNode rotateRight(ListNode head, int n){
    if ( head == null || n < 1)
      return head;

    int index = 1;

    ListNode flagNode = head;
    ListNode rotatedHead = head;
    int length = 0;
    while(flagNode != null ){
      flagNode = flagNode.next;
      length++;
    }
    if ( n == length )
      return head;
    flagNode = head;
    while (index < n % length ){
      flagNode = flagNode.next;

      index++;
    }

    if ( flagNode == null )
      return head; // or throw exception

    ListNode parentRotatedNode = rotatedHead;
    while(flagNode.next != null){
      parentRotatedNode = rotatedHead;
      rotatedHead = rotatedHead.next;
      flagNode = flagNode.next;
    }

    if ( rotatedHead == head )
      return head;
    parentRotatedNode.next = null;
    flagNode.next = head;
    return rotatedHead;

  }

  public ListNode reverseList(ListNode head) {
    if ( head == null )
      return null;
    ListNode node = head;
    ListNode newHead = null;

    while ( node != null){
      ListNode next = node.next;
      node.next = newHead;
      newHead = node;
      node = next;
    }
    return newHead;
  }

}
