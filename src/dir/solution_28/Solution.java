package dir.solution_28;

public class Solution {
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        int pointHay = 0;
        char cNeedle = needle.charAt(0);
        int lenHay = haystack.length();
        int lenNeedle = needle.length();
        while (pointHay <= lenHay - lenNeedle) {
            if (haystack.charAt(pointHay) == cNeedle) {
                if (haystack.substring(pointHay, pointHay + lenNeedle).equals(needle)) return pointHay;
            }
            pointHay++;
        }
        return -1;
    }
}
