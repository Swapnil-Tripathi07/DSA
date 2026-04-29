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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                current.next = temp1;
                temp1 = temp1.next;
            }
            else{
                current.next = temp2;
                temp2 = temp2.next;
            }
            current = current.next;
        }
        if(temp1!=null){
            current.next = temp1;
        }
        else{
            current.next = temp2;
        }
        return dummy.next;
    }
}