package dir.lib.solution_2;

import java.util.LinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {this.val = val; this.next = next; }

    // 将整数数组转化为链表
    public static ListNode arrayToListNode (int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;
        ListNode head = new ListNode(nums[0]);
        if (len == 2) {
            head.next = new ListNode(nums[1]);
            return head;
        }
        ListNode next = new ListNode(nums[1]);
        head.next = next;
        for (int i = 2; i < len; i++) {
            next.next = new ListNode(nums[i]);
            next = next.next;
        }
        return head;
    }

    // 将链表在控制台输出
    public static void display(ListNode ln) {
        ListNode temp = ln;
        while (temp.next != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }


}
