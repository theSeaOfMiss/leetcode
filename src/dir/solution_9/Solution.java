package dir.solution_9;

// 回文数
public class Solution {
    public boolean isPalindrome(int x) {

        String s = Integer.toString(x);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i)) return false;
        }
        return true;
    }
}
