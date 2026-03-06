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
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        String decimal = "";
        while(curr!=null){
            decimal = decimal + curr.val;
            curr = curr.next;
        }
        int count = 0;
        int original = 0;
        int i = decimal.length()-1;
        while(i>=0){
            if(decimal.charAt(i) == '1'){
                original = original+Math.powExact(2,count);
                i--;
                count++;
            }
            else{
                i--;
                count++;
            }
        }
        return original;

    }
}