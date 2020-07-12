package dir.solution_26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len == 1) return 1;
        int leftPoint = 0;
        int rightPoint = 1;
        int res = 1;
        while (rightPoint < len) {
            if (nums[rightPoint] != nums[leftPoint]) {
                res++;
                leftPoint++;
                nums[leftPoint] = nums[rightPoint];
            }
            rightPoint++;
        }
        return res;
    }
}