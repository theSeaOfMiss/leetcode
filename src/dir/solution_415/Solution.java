package dir.solution_415;

class Solution {
    public static String addStrings(String num1, String num2) {
        if (num1.length() >= num2.length()) {
            return addModule(num1, num2);
        } else {
            return addModule(num2, num1);
        }
    }
    private static String addModule(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int count1 = num1.length() - 1;
        int count2 = num2.length() - 1;
        while (count2 >=0) {
            int tempI = num1.charAt(count1) + num2.charAt(count2) + carry - '0' * 2;
            if (tempI > 9) {
                sb.append(tempI % 10);
                carry = 1;
            } else {
                sb.append(tempI);
                carry = 0;
            }
            count1--;
            count2--;
        }
        while (count1 >= 0) {
            int tempII = num1.charAt(count1) + carry - '0';
            if (tempII > 9) {
                sb.append(tempII % 10);
                carry = 1;
            } else {
                sb.append(tempII);
                carry = 0;
            }
            count1--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
