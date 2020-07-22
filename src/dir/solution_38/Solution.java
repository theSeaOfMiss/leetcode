package dir.solution_38;

public class Solution {
    public String countAndSay(int n) {
        String[] seq = new String[30];
        int count;
        char temp;
        String s;
        seq[0] = "1";
        for (int i = 1; i < n; i++) {
            s = seq[i - 1];
            temp = s.charAt(0);
            count = 1;
            StringBuilder sb = new StringBuilder();

            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == temp) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(temp);
                    count = 1;
                    temp = s.charAt(j);
                }
            }
            sb.append(count);
            sb.append(temp);
            seq[i] = sb.toString();
        }
        return seq[n - 1];
    }
}
