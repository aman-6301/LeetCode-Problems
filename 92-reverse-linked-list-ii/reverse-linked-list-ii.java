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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode curr = head;
        ListNode before = null;
        int pos = 1;
        while(curr != null && pos < left){
            before = curr;
            curr = curr.next;
            pos++;  
        }

        // reverse right-left+1 times
        ListNode temp = curr;
        ListNode prev = null;
        int times = right - left +1;
        for(int i=1;i<=times;i++){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        curr.next = temp;
        if(before != null){
            before.next = prev;
            return head;
        }

        return prev;

        
    }
}