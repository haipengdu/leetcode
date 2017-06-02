package com.hdu;

/**
 * Created by hdu on 4/19/17.
 */
public class ReverseList {

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode pre = head;
    ListNode current = pre.next;
    ListNode next = null;

    while (current != null){
      next = current.next;
      current.next = pre;
      pre = current;
      current = next;
    }
    return head;
  }

}
