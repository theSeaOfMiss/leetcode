package dir.solution_39;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] map = new int[200];
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            recursion(candidates, target, i, ls, map);
        }
        return ls;
    }
    public void recursion(int[] candidates, int target, int index, List<List<Integer>> ls, int[] map) {
        int value = candidates[index];
        if (value > target) return;
        if (value == target) {
            map[target]++;
            ls.add(buildList(candidates, map));
            map[target]--;
            return;
        }

        int quo = target / value;
        for (int i = quo; i > 0; i--) map[value]++;
        for (int i = quo; i > 0; i--) {
            int diff = target - i * value;

            if (diff == 0) ls.add(buildList(candidates, map));
            else {
                for (int j = index + 1; j < candidates.length; j++) {
                    recursion(candidates, diff, j, ls, map);
                }
            }

            map[value]--;
        }

    }
    public List<Integer> buildList(int[] candidates, int[] map) {
        List<Integer> res = new ArrayList<>();
        for (int candidate:candidates) {
            for (int i = 0; i < map[candidate]; i++) {
                res.add(candidate);
            }
        }
        return res;
    }
}
