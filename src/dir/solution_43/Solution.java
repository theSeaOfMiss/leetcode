package dir.solution_43;

public class Solution {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length();
        String ans = mul(num2, num1.charAt(0), len1 - 1);
        for (int i = 1; i < num1.length(); i++) {
            ans = add(ans, mul(num2, num1.charAt(i), len1 - 1 - i));
        }
        return ans;
    }
    private static String mul(String num, char digit, int shift) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int digitI = digit - '0';
        while (shift > 0) {
            sb.append(0);
            shift--;
        }
        for (int i = num.length() - 1; i >= 0; i--) {
            char tempC = num.charAt(i);
            int tempI = (tempC - '0') * digitI + carry;
            carry = tempI / 10;
            sb.append(tempI % 10);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
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
    private static String add(String num1, String num2) {
        if (num1.length() >= num2.length()) {
            return addModule(num1, num2);
        } else {
            return addModule(num2, num1);
        }
    }

    public static void main(String[] args) {
        String s1 = "18";
        String s2 = "34";
        multiply(s1, s2);
    }
}
