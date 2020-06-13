package dir.solution_2;
import dir.lib.solution_2.ListNode;

//两数相加
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] temp1 = listToArray(l1);
        int[] temp2 = listToArray(l2);
        int[] temp3 = addTwoArray(temp1, temp2);
        return arrayToList(temp3);
    }

    public static ListNode arrayToList(int[] digits) {
        int len = digits.length;
        ListNode head = new ListNode(digits[0]);
        ListNode temp;
        ListNode next;

        switch (len) {
            case 1:
                break;
            case 2:
                temp = new ListNode(digits[1]);
                head.next = temp;
                break;
            default:
                temp = new ListNode(digits[1]);
                head.next = temp;
                for (int i=2; i<len; i++) {
                    next = new ListNode(digits[i]);
                    temp.next = next;
                    temp = next;
                }
        }
        return head;
    }

    public static int[] listToArray(ListNode l) {
        StringBuilder string = new StringBuilder();
        int len;
        do {
            string.append(l.val);
            l = l.next;
        } while (l != null);
        len = string.length();
        int[] array = new int[len];

        for(int i=0; i<len; i++) {
            array[i] = (int)string.charAt(i) - 48;
        }
        return array;
    }


    // array1的数组长度要大于等于array2
    public static int[] addTwoArray(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;
        if (len1>len2) {
            addTwoArrayModule(array1, array2, len2);
            return arrayCarry(array1);
        } else {
            addTwoArrayModule(array2, array1, len1);
            return arrayCarry(array2);
        }
    }
    private static void addTwoArrayModule(int[] a1, int[] a2, int lenMin) {
        for (int i=0; i<lenMin; i++) {
            a1[i] += a2[i];
        }
    }
    private static int[] arrayCarry(int[] a) {
        int len = a.length;
        for (int i=0; i<len; i++) {
            // 需要进位
            if (a[i]>9 && i==len-1) {
                a = java.util.Arrays.copyOf(a, len+1);
                a[i] -= 10;
                a[len] = 1;
            } else if (a[i]>9) {
                a[i] -= 10;
                a[i+1] += 1;
            }
        }
        return a;
    }

}

