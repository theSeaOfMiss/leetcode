package dir.solution_32;

public class Solution {
    public static int longestValidParentheses(String s) {
        if (s == null) return 0;
        int len = s.length();
        int res, dobber, validLen;
        res = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                dobber = 1;
                validLen = 1;
                for (int j = i + 1; j < len; j++) {
                    if (s.charAt(j) == '(') dobber++;
                    else dobber--;

                    if (dobber < 0) break;
                    validLen++;
                    if (dobber == 0) res = Math.max(res, validLen);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "()(";
//        System.out.println(s.length());
        System.out.println(longestValidParentheses(s));

    }
}
