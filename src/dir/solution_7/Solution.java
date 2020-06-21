package dir.solution_7;

public class Solution {
    public static int reverse(int x) {
        StringBuilder s = new StringBuilder();
        s.append(x);
        if (s.charAt(0) == '-') {
            s.delete(0, 1);
            s.reverse();
            s.insert(0, '-');
        } else {
            s.reverse();
        }

        try {
            return Integer.parseInt(s.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
