public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}


public class reverseLinkedListRecursive {
  
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) 
      return head;
    /*
     * if (head == null) return null;   //what is the reverse of null(the empty list)? null.
     * if (head.next == null) return head; //what is the reverse of one element list. the element.
     * what is the reverse of an n element list? the reverse of the second element on followed by the first element.
     *
     */

    ListNode remaining = reverseList(head.next);  //reverse the rest part
    head.next.next = head;     //make the link from rest to head
    head.next = null;          //break the link from head to rest
    return remaining;         //return the new head  

  }
}


/*
 * hint:  head, first, rest
 */
