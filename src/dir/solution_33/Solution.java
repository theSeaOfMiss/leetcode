package dir.solution_33;

public class Solution {
    static char[] parts = new char[]{'A', 'B'};

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int len = nums.length;
        if (len == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        int start = nums[0];
        int end = nums[len - 1];
        int m;
        char part;
        int ref;
        int temp = -1;
        // inf[0] = leftpoint; 左指针
        // inf[1] = rightpoint; 右指针
        // inf[2] = res; 结果
        int[] inf = new int[3];
        inf[1] = len - 1;
        inf[2] = -1;

        if (target == start) return 0;
        if (target == end) return len - 1;
        if (end > start) {
            if (end > target && target > start) {
                
            } else return -1;
        }
        if (target > start) {
            part = parts[0];
            ref = end;
        }
        else {
            part = parts[1];
            ref = start;
        }

        while (inf[1] > inf[0]) {
            m = (inf[1] + inf[0]) / 2;
            if (m == temp) break;
            temp = m;
            if (part == parts[0]) {
                if (target == nums[m]) return m;
                else if (target < nums[m] || (nums[m] < end && end < start)) inf[1] = m;
                else inf[0] = m;
            } else {
                if (target == nums[m]) return m;
                else if (target > nums[m] || (nums[m] > start && end < start)) inf[0] = m;
                else inf[1] = m;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 8;
        search(nums, target);
    }
}
