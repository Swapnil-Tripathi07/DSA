class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;

        for (int i = 1; i < left; i++) {
            temp = temp.next;
        }

        ListNode start = temp.next;
        ListNode prev = null;
        ListNode current = start;
        ListNode neext = null;

        int count = right - left + 1;

        while (count != 0) {
            neext = current.next;
            current.next = prev;
            prev = current;
            current = neext;
            count--;
        }
        temp.next = prev;
        start.next = current;

        return dummy.next;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna