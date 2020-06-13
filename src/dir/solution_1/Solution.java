package dir.solution_1;

import java.util.HashMap;

//两数之和
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int diff;
        int temp;
        int[] dix = new int[2];
        for(int i=0; i<nums.length; i++) {
            temp = nums[i];
            diff = target - temp;
            if(map.get(diff) == null) {
                map.put(temp, i);
            } else {
                dix[0] = map.get(diff);
                dix[1] = i;
                return dix;
            }
        }
        throw new IllegalArgumentException("No two sum value");
    }
}
