package dir.solution_42;

public class Solution {
    public int trap(int[] height) {
        int res = 0;
        int temp;
        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0) {
                temp = findBorder(height, i);
                if (temp >= height.length) continue;
                res += calculate(height, i, temp);
                i = temp - 1;
            }
        }
        return res;
    }
    private int calculate(int[] height, int left, int right) {
        int area = Math.min(height[left], height[right]) * (right - left - 1);
        for (int i = left + 1; i < right; i++) {
            area -= height[i];
        }
        return area;
    }

    private int findBorder(int[] height, int start) {
        int end = start + 1;
        for (int i = start + 1; i < height.length; i++) {
            if (height[i] >= height[start]) return i;
            end = height[end] > height[i] ? end : i;
        }
        return end;
    }
}
