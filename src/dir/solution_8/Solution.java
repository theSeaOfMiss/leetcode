package dir.solution_8;

import java.util.Stack;

public class Solution {
    public static int myAtoi(String str) {
        int len = str.length();
        int res = 0;
        int sign = 1;
        // map的k对应Ascii值
        int[] map = new int[128];
        // 空格
        map[32] = 1;
        // + - 号
        map[43] = 2;
        map[45] = 3;
        // 数字
        for (int i = 48; i < 58; i++) {
            map[i] = 4;
        }

        Stack<Character> stack = new Stack<>();
        int count = 0;
        char tempChar;
        int  tempInt;
        do {
            if (count >= len) break;
            tempChar = str.charAt(count);
            count++;
            tempInt = map[tempChar];
            if (tempInt == 2 || tempInt == 3) {
                if (tempInt == 3) sign = -1;
                map[32] = 0;
                map[43] = 0;
                map[45] = 0;
            }
            if (tempInt == 4) {
                map[32] = 0;
                map[43] = 0;
                map[45] = 0;
                stack.push(tempChar);
            }
        } while (tempInt != 0);

        count = 0;
        if (sign == 1) {
            while (!stack.isEmpty()) {
                tempChar = stack.pop();
                if (res == Integer.MAX_VALUE) return res;
                res += ((int)tempChar - 48) * Math.pow(10, count);
                count++;
            }
        } else {
            while (!stack.isEmpty()) {
                tempChar = stack.pop();
                if (res == Integer.MIN_VALUE) return res;
                res -= ((int)tempChar - 48) * Math.pow(10, count);
                count++;

            }
        }
        return res;
    }

}
