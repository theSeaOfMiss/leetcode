package dir.solution_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) recursion(candidates, target, i, ls, l);
        return ls;
    }
    public void recursion(int[] candidates, int target, int index, List<List<Integer>> ls, List<Integer> l) {
        int value = candidates[index];
        if (value > target) return;
        if (value == target) {
            l.add(value);
            ls.add(new ArrayList<>(l));
            l.remove(l.size() - 1);
            return;
        }

        int quo = target / value;
        for (int i = quo; i > 0; i--) l.add(value);
        for (int i = quo; i > 0; i--) {
            int diff = target - i * value;

            if (diff == 0) ls.add(new ArrayList<>(l));
            else {
                for (int j = index + 1; j < candidates.length; j++) {
                    recursion(candidates, diff, j, ls, l);
                }
            }

            l.remove(l.size() - 1);
        }

    }
}
