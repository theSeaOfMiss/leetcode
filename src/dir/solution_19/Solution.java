package dir.solution_19;

import dir.lib.solution_2.*;

public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode headFront = new ListNode(-1);
        headFront.next = head;
        ListNode startFront = headFront;
        ListNode start = head;
        ListNode end = head.next;
        for (int i = 2; i < n; i++) {
            end = end.next;
        }
        while (end.next != null) {
            startFront = start;
            start = start.next;
            end = end.next;
        }
        if (n == 1) start.next = null;
        else startFront.next = start.next;

        return headFront.next;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        ListNode head = ListNode.arrayToListNode(nums);
        ListNode.display(head);
        head = removeNthFromEnd(head, 2);
        ListNode.display(head);

    }
}
