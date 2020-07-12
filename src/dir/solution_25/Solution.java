package dir.solution_25;

import dir.lib.solution_2.ListNode;

public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] lists = new ListNode[2 * k];
        if (head == null) return null;
        int count = 0;
        for (int i = 0; i < 2 * k; i++) {
            if (head == null) break;
            lists[i] = head;
            head = head.next;
            count++;
        }
        if (count < k) return lists[0];
        for (int i = k - 1; i > 0; i--) {
            lists[i].next = lists[i - 1];
        }
        if (count < 2 * k) {
            lists[0].next = lists[k];
            return lists[k - 1];
        }
        lists[0].next = lists[2 * k - 1];
        reverseKGroup(lists[k], k);
        return lists[k - 1];
    }
}
