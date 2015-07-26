public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class reverseLinkedList {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }else if (head.next == null) {
      return head;
    }else {
      ListNode prev = null;
      ListNode curr = head;
      while (curr != null) {
        ListNode next = curr.next;
        //reverse nodes
        curr.next = prev;
        //move prev and curr one step
        prev = curr;
        curr = next;

      }//end while
      return prev;
    }//end if else
  }

}
