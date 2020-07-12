package dir.solution_27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int leftPoint = 0;
        int rightPoint = 0;
        int res = 0;
        while (rightPoint < len) {
            if (nums[rightPoint] != val) {
                nums[leftPoint] = nums[rightPoint];
                res++;
                leftPoint++;
            }
            rightPoint++;
        }
        return res;
    }
}
