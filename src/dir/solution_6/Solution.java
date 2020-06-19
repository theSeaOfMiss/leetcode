package dir.solution_6;

import java.util.HashMap;
public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        int[] rows = new int[numRows];
        int base;
        int remainder;
        int index;

        if (numRows == 1) {
            return s;
        }

        if (numRows < 1) {
            throw new IllegalArgumentException("numRows is illegal!");
        }

        for (int i = 0; i < len; i++) {
            base = 2 * (numRows - 1);
            remainder = i % base;
            if (remainder >= numRows) {
                remainder = numRows * 2 - remainder - 2;
            }
            map.put(remainder + "0" + rows[remainder], i);
            rows[remainder]++;
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < rows[i]; j++) {
                index = map.get(i + "0" + j);
                res.append(s.charAt(index));
            }
        }
        return res.toString();
    }
}
