package dir.solution_16;

import java.util.Arrays;

public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int temp, rightPoint, leftPoint, sum;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            temp = target - nums[i];
            rightPoint = len - 1;
            leftPoint = i + 1;
            while (leftPoint < rightPoint) {
                sum = nums[leftPoint] + nums[rightPoint];
                if (sum < temp) {
                    leftPoint++;
                    res = Math.abs(target - res) < Math.abs(temp - sum) ? res : sum + nums[i];
                } else if (sum == temp) {
                    return sum + nums[i];
                } else {
                    rightPoint--;
                    res = Math.abs(target - res) < Math.abs(temp - sum) ? res : sum + nums[i];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 0));

    }
}
