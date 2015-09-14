/* problem: Swap nodes in pairs
 * given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * the idea is that: we need to get a hold of 3, then we point 1 to 3, 2 to 1,
 *
 */

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}//end ListNode

public class Solution {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode h = new ListNode(0);
    h.next = head;
    ListNode p = h;

    while (p.next != null && p.next.next != null) {
      //use t1 to track first node
      ListNode t1 = p;
      p = p.next;
      t1.next = p.next;

      //use t2 to track next node of the pair
      ListNode t2 = p.next.next;
      p.next.next = p;
      p.next = t2;
    }//end while

    return h.next;
  }//end swapPairs

}//end class Solution




