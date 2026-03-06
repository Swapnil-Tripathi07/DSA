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
    public boolean isPalindrome(ListNode head) {
        boolean flag = true;;
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        while(current!=null){
            stack.push(current.val);
            current = current.next;
        }
        current = head;
        while(!stack.isEmpty() && current!=null){
            if(current.val == stack.peek()){
                current = current.next;
                stack.pop();
            }
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}