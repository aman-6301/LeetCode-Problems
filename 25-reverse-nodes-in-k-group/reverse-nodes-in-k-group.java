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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGrpEnd = dummy;

        while(true){
            ListNode kth = prevGrpEnd;
            for(int i =0;i<k;i++){
                kth = kth.next;
                if(kth == null) return dummy.next;
            }

            ListNode grpStrt = prevGrpEnd.next;
            ListNode nextGrp = kth.next;

            //reverse
            ListNode prev = nextGrp;
            ListNode curr = grpStrt;
            while(curr != nextGrp){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            prevGrpEnd.next = kth;

            prevGrpEnd = grpStrt;
        }
    }
}