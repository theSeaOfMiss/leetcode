package dir.solution_21;

import dir.lib.solution_2.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode front = new ListNode(-1);
        ListNode point;
        if (l1.val > l2.val) {
            point = l2;
            l2 = l2.next;
        } else {
            point = l1;
            l1 = l1.next;
        }
        front.next = point;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                point.next = l2;
                l2 = l2.next;
            } else {
                point.next = l1;
                l1 = l1.next;
            }
            point = point.next;
        }
        if (l1 != null) point.next = l1;
        if (l2 != null) point.next = l2;
        return front.next;
    }
}
