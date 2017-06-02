package com.hdu;

/**
 * Created by hdu on 4/23/17.
 */
public class DeleteDuplicationInList {

  public static void main(String[] args){
    ListNode root = new ListNode(1);
    root.next = new ListNode(1);
    CodeUtil.printList(new DeleteDuplicationInList().deleteDuplicates(root));
  }
  public ListNode deleteDuplicates(ListNode head) {
    if ( head == null || head.next == null)
      return head;
    ListNode next = head.next;
    ListNode current = head;

    while (current != null && next != null){
      if (current.val == next.val){
          current.next = next.next;
          next.next = null;
          next = current.next;
      }else{
        current = next;
        next = current.next;
      }
    }

    return head;
  }
}
