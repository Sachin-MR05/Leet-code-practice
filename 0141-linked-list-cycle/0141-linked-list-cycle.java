/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if( head == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!=null && fast.next!=null && fast.next.next != null && fast != slow){
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast == slow;

    }
}