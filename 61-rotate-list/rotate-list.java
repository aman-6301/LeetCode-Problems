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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next ==  null){
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        k = k % size;
        if(k == 0){
            return head;
        }
        temp = head;
        for(int i =1;i<size-k;i++){
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;

        temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = head;

        return newHead;
    }
}