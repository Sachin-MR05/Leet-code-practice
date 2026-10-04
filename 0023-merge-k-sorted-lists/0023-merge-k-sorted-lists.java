/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0) return null;

        ListNode temp = lists[0];
        for(int i =1;i<lists.length;i++){
           temp =  merge(temp,lists[i]);
        }
        return temp;
    }
    public static ListNode merge(ListNode l1, ListNode l2){

        ListNode temp = new ListNode(0);
        ListNode curr = temp;

        while(l1 != null && l2 != null){

            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;

            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1!=null) curr.next =l1;
        if(l2!=null) curr.next =l2;

        return temp.next;
    }
}