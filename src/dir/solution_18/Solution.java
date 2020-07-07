package dir.solution_18;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int leftPoint, rightPoint, temp1, temp2, diff, sum;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len == 0) return res;

        int cache1 = nums[0] - 1;

        for (int i = 0; i < len; i++) {
            temp1 = nums[i];
            if (temp1 == cache1) continue;
            else cache1 = temp1;

            int cache2 = cache1 - 1;
            for (int j = i + 1; j < len; j++) {
                temp2 = nums[j];
                if (temp2 == cache2) continue;
                else cache2 = temp2;
                diff = target - temp1 - temp2;
                leftPoint = j + 1;
                rightPoint = len - 1;

                int cache3 = cache1 - 1;
                while (leftPoint < rightPoint) {
                    sum = nums[leftPoint] + nums[rightPoint];
                    if (sum > diff) {
                        rightPoint--;
                    } else if (sum == diff){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(temp1);
                        temp.add(temp2);
                        temp.add(nums[leftPoint]);
                        temp.add(nums[rightPoint]);
                        res.add(temp);
                        cache3 = nums[rightPoint];
                        while (leftPoint < rightPoint) {
                            rightPoint--;
                            if (nums[rightPoint] != cache3) break;
                        }
                    } else {
                        leftPoint++;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        fourSum(new int[]{1, 7, 7, 7, 7}, 28);
    }
}
