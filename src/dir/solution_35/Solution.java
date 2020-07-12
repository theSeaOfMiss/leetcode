package dir.solution_35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int point = 0;
        while (point < nums.length) {
            if (nums[point] == target) return point;
            if (nums[point] > target) break;
            point++;
        }
        return point;
    }
}
