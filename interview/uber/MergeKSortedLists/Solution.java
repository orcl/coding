/* problem: Merge K sorted lists
 * merge k sorted linked lists and return it as one sorted list. analyze and describe its complexity.
 */


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> heap  =  new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode left, ListNode right) {
                if (left == null) {
                    return 1;
                }else if (right == null) {
                    return -1;
                }
                return left.val - right.val;
            }
        });
    
 
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail  = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next     = head;
            tail          = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }//end while
        

    
    }//end mergeKLists



}//end Solution









