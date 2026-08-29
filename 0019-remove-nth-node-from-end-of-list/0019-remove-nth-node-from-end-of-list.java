class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove nth node from the end
        second.next = second.next.next;

        return dummy.next;
    }
}