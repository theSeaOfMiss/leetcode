package dir.solution_14;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        int minLen = strs[0].length();
        char temp;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < len; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        for (int i = 0; i < minLen; i++) {
            temp = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                if (temp != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}