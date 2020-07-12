package dir.solution_22;

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int dobber = 0;
        int count = 0;
        recursion(l, sb, count, dobber, n);
        return l;
    }
    private static void recursion(List<String> l, StringBuilder sb, int count, int dobber, int n) {
        count++;
        if (count > 2 * n || dobber < 0) {
            if (dobber == 0) l.add(sb.toString());
            return;
        }
        dobber++;
        sb.append('(');
        recursion(l, sb, count, dobber, n);
        sb.delete(sb.length()-1, sb.length());
        dobber -= 2;
        sb.append(')');
        recursion(l, sb, count, dobber, n);
        sb.delete(sb.length()-1, sb.length());
    }
}
