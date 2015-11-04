public class Solution {


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode curr = helper;

        while (curr.next != null) {
            if (curr.next.val == val) {
                ListNode next = curr.next;
                curr.next = next.next;
            }else {
                curr = curr.next;
            }
        }//end while

        return helper.next;
    }

}
