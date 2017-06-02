package com.hdu;

/**
 * Created by hdu on 4/26/17.
 */
public class OddEvenList {

  public static void main(String [] args){
    ListNode root = new ListNode(1);
    ListNode node = root;
    for( int i =0; i < 4; i++) {
      node.next = new ListNode(i + 2);
      node = node.next;
    }

    CodeUtil.printList(root);
    CodeUtil.printList(new OddEvenList().oddEvenList(root));
  }
  public ListNode oddEvenList(ListNode head) {

    if ( head == null || head.next == null)
      return head;
    ListNode odd = head;
    ListNode oddHead = odd;
    ListNode even = head.next;
    ListNode evenHead = even;

    while (odd != null){
      if (even != null) {
        odd.next = even.next;
        odd = even.next;

      }
      else {
        odd.next = null;
        odd = null;
      }

      if ( odd != null) {
        even.next = odd.next;
        even = odd.next;
      }
      else
        even = null;

    }

    odd = oddHead;
    while(odd.next != null){
      odd = odd.next;
    }
    odd.next = evenHead;
    return oddHead;
  }
}
