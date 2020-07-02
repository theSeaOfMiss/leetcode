package dir.solution_13;

import java.util.HashMap;
public class Solution {
    public static int romanToInt(String s) {
        int[] range = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = 0;
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int j = 0; j < range.length; j++) {
            map.put(roman[j], range[j]);
        }
        for (; i < s.length() - 1; i++) {
            if (map.get(s.substring(i, i + 2)) != null) {
                res += map.get(s.substring(i, i + 2));
                i++;
            } else {
                res += map.get(s.substring(i, i + 1));
            }
        }
        if (i != s.length() - 1) res += map.get(s.substring(i, i + 1));

        return res;
    }
    public static void main(String[] args) {
        romanToInt("hello");
    }
}
