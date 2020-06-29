package dir.solution_12;

public class Solution2 {
    public String intToRoman(int num) {
        int[] range = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000, 4000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int len = range.length;
        StringBuilder res = new StringBuilder();
        int temp;
        for (int i = len - 1; i > 0; i--) {
            if (num >= range[i - 1] && num < range[i]) {
                temp = num / range[i - 1];
                for (;temp > 0; temp--) {
                    res.append(roman[i - 1]);
                    num -= range[i - 1];
                }
                if (num == 0) return res.toString();
            }
        }
        return res.toString();
    }
}
