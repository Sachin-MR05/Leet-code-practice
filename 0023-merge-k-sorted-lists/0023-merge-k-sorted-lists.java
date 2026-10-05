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

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val- b.val);

        ListNode temp = new ListNode(0);

        ListNode curr = temp;

        for(int i =0;i<lists.length;i++){
            if(lists[i]!=null)
           pq.add(lists[i]);
        }

        while(!pq.isEmpty()){
            curr.next= pq.poll();
            curr = curr.next;
            if(curr.next != null)
            pq.add(curr.next);
        }
        return temp.next;
    }
    // public static ListNode merge(ListNode l1, ListNode l2){

    //     ListNode temp = new ListNode(0);
    //     ListNode curr = temp;

    //     while(l1 != null && l2 != null){

    //         if(l1.val<l2.val){
    //             curr.next = l1;
    //             l1 = l1.next;

    //         }
    //         else{
    //             curr.next = l2;
    //             l2 = l2.next;
    //         }
    //         curr = curr.next;
    //     }
    //     if(l1!=null) curr.next =l1;
    //     if(l2!=null) curr.next =l2;

    //     return temp.next;
    // }
}