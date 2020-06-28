package dir.solution_11;

public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int area = 0;
        int tempArea;
        int stop;
        int index;
        int point;
        for (int i = 0; i < len - 1; i++) {
            point = height[i];
            if (point == 0) continue;
            stop = Math.max(area / point, i);
            index = len - 1;
            while (index > stop) {
                tempArea = Math.min(point, height[index]) * (index - i);
                if (tempArea > area) {
                    area = tempArea;
                    stop = area / point;
                }
                index--;
            }
        }
        return area;
    }
}
