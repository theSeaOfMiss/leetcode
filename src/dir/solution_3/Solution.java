package dir.solution_3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, len = s.length(), count;
        StringBuilder startC = new StringBuilder();
        for (int i = 0; i < len; i++) {
            count = i;
            while (count < len) {
                if (startC.indexOf(String.valueOf(s.charAt(count))) == -1) {
                    startC.append(s.charAt(count));
                } else {
                    break;
                }
                count ++;
            }
            l = Math.max(l, count - i);
            startC.delete(0, startC.length());
        }
        return l;
    }
}
