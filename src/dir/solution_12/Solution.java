package dir.solution_12;

public  class Solution {

    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        do {
            num = binning(num, res);
        } while (num != -1 && num != 0);

        return res.toString();
    }

    private static int binning(int num, StringBuilder sb) {
        int temp;
        if (1000 <= num  && num < 4000) {
            temp = num / 1000;
            for (int i = 0; i < temp; i++) {
                sb.append('M');
            }
            return num - temp * 1000;
        }

        if (500 <= num && num < 1000) {
            if (num / 100 == 9) {
                sb.append("CM");
                num -= 900;
            } else {
                sb.append('D');
                num -= 500;
            }
            return num;
        }

        if (100 <= num && num < 500) {
            if (num / 100 == 4) {
                sb.append("CD");
                num -= 400;
            } else {
                temp = num / 100;
                for (int i = 0; i < temp; i++) {
                    sb.append('C');
                    num -= 100;
                }
            }
            return num;
        }

        if (50 <= num && num < 100) {
            if (num / 10 == 9) {
                sb.append("XC");
                num -= 90;
            } else {
                sb.append('L');
                num -= 50;
            }
            return num;
        }

        if (10 <= num && num < 50) {
            if (num / 10 == 4) {
                sb.append("XL");
                num -= 40;
            } else {
                temp = num / 10;
                for (int i = 0; i < temp; i++) {
                    sb.append('X');
                    num -= 10;
                }
            }
            return num;
        }

        if (5 <= num && num < 10) {
            if (num == 9) {
                sb.append("IX");
                num -= 9;
            } else {
                sb.append('V');
                num -= 5;
            }
            return num;
        }
        if (1 <= num && num < 5) {
            if (num == 4) {
                sb.append("IV");
                num -= 4;
            } else {
                temp = num;
                for (int i = 0; i < temp; i++) {
                    sb.append('I');
                    num -= 1;
                }
            }
            return num;
        }
        return -1;
    }
}
