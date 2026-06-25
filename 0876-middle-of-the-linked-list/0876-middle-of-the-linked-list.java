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
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int count = 0;
        if(current.next==null)
        return current;
        while(current!= null){
            count++;
            current = current.next;
        }
        count/=2;
        current = head;
        ListNode temp = null;
        while(count!=0){
            current = current.next;
            temp = current;
            count--;
        }
        return temp;

    }
}