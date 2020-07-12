package dir.solution_24;

import dir.lib.solution_2.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head.next;
        module(head);
        return res;
    }
    private static void module(ListNode node) {
        if (node == null || node.next == null) return;
        ListNode temp2 = node.next;
        ListNode temp3 = temp2.next;
        if (temp3 == null) {
            temp2.next = node;
            node.next = null;
            return;
        }
        ListNode temp4 = temp3.next;
        if (temp4 == null) {
            node.next = temp3;
            temp2.next = node;
            return;
        }
        node.next = temp4;
        temp2.next = node;
        module(temp3);
    }
}
