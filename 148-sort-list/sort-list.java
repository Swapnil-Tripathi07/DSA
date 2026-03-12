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
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode temp = head;
        while(temp!=null){
            pq.add(temp.val);
            temp = temp.next;
        }
        int n = pq.size();
        temp = head;
        for(int i = 0 ; i<n ; i++){
            temp.val = pq.poll();
            temp = temp.next;
        }
        return head;
    }

}