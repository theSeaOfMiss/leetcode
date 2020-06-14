package dir.solution_3;

import java.util.HashMap;
public class Example_1 {
    public int lengthOfLongestSubstring(String s) {
        // k为滑动窗口子串开始端
        int k = -1;
        int res = 0;
        char c;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            // 字符c在map中，且上次出现的下标大于当前子串的起始下标
            if (map.get(c) != null && map.get(c) > k) {
                k = map.get(c);
                map.put(c, i);
            } else {
                map.put(c, i);
                res = Math.max(res, i - k);
            }
        }
        return res;
    }
}
