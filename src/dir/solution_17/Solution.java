package dir.solution_17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> letterCombinations(String digits) {
        String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<StringBuilder> sbList = new ArrayList<>();
        List<String> sList = new ArrayList<>();
        if (digits == null) return null;
        int index = digits.charAt(0)-50;
        int len, size;
        // 初始化
        for (int i = 0; i < map[index].length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(map[index].charAt(i));
            sbList.add(sb);
        }
        for (int i = 1; i < digits.length(); i++) {

            index = digits.charAt(i) - 50;
            // 数字对应的字母数量
            len = map[index].length();
            // 给sbList扩容
            size = sbList.size();
            for (int j = 1; j < len; j++) {
                for (int z = 0; z < size; z++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sbList.get(z));
                    sbList.add(sb);
                }
            }
            // 给sbList添加尾巴
            for (int j = 0; j < len; j++) {
                for (int z = j * size; z < (j + 1) * size; z++) {
                    sbList.get(z).append(map[index].charAt(j));
                }
            }
        }

        for (StringBuilder sb:sbList) {
            sList.add(sb.toString());
        }
        return sList;
    }
    public static void main(String[] args) {
        letterCombinations("23");
    }
}
