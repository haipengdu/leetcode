package com.hdu;

/**
 * Created by hdu on 5/29/17.
 */
public class PalindromeLinkedList {

 public static void  main(String [] args){
   ListNode node = new ListNode(1);
   node.next = new ListNode(2);
   node.next.next = new ListNode(3);
   CodeUtil.printList(node);
   CodeUtil.printList(new PalindromeLinkedList().reverse(node));
 }

 public boolean isPalindrome(ListNode head){
   if ( head == null)
     return false;
   if (head.next == null)
     return true;
   ListNode slow = head, fast = head;

   while(fast != null && fast.next != null){
     slow = slow.next;
     fast = fast.next.next;
   }

   if ( fast != null)
     slow = slow.next;

   slow = reverse(slow);
   fast = head;

   while (slow != null) {
     if (fast.val != slow.val) {
       return false;
     }
     fast = fast.next;
     slow = slow.next;
   }
   return true;

 }
  private ListNode reverseList(ListNode head){
    if ( head == null )
      return head;

    ListNode newHead = head;
    ListNode next = newHead.next;
    while (newHead != null && newHead.next != null){
      next = newHead.next;
      ListNode nextOfNext = next.next;
      next.next = newHead;
      newHead.next = null;
      newHead = nextOfNext;
    }
    if ( newHead == null)
    newHead = next;
    else
      newHead.next = next;
    return newHead;

  }

  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
