package dir.solution_42;

//使用双指针
public class Example2 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) left_max = height[left];
                else ans += (left_max - height[left]);
                left++;
            } else {
                if (height[right] >= right_max) right_max = height[right];
                else ans += (right_max - height[right]);
                right--;
            }
        }
        return ans;
    }
}