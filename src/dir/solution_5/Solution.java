package dir.solution_5;

public class Solution {
    public static String longestPalindrome(String s) {
        int[] inf = new int[5];
        for (int i : inf) {
            i = 0;
        }
        int len = s.length();
        if (len == 0) {
            return "";
        }
        for (int i = 1; i < (len - 1) * 2; i++) {

            if (i % 2 == 1) {
                inf[0] = (i - 1) / 2;
                inf[1] = (i + 1) / 2;
                module(s, inf);
            } else {
                inf[0] = i / 2 - 1;
                inf[1] = i / 2 + 1;
                module(s, inf);
            }
        }
        return s.substring(inf[2], inf[3]+1);
    }

    private static void module(String s, int[] inf) {
        int startLeft = inf[0];
        int startRight = inf[1];
        int max = inf[4];
        int len = s.length();
        if (s.charAt(startLeft) == s.charAt(startRight)) {
            while (true) {
                if (startLeft < 0 || startRight > len - 1) {
                    startLeft++;
                    startRight--;
                    break;
                }

                if (s.charAt(startLeft) == s.charAt(startRight)) {
                    startLeft--;
                    startRight++;
                } else {
                    startLeft++;
                    startRight--;
                    break;
                }
            }
            if (startRight - startLeft > max) {
                inf[2] = startLeft;
                inf[3] = startRight;
                inf[4] = startRight - startLeft;
            }
        }
    }
}


