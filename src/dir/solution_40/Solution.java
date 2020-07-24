package dir.solution_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) continue;
            recursion(candidates, target, i, ls, l);
        }
        return ls;
    }
    public void recursion(int[] candidates, int target, int index, List<List<Integer>> ls, List<Integer> l) {
        int value = candidates[index];
        if (value > target) return;
        l.add(value);
        if (value == target) {
            ls.add(new ArrayList<>(l));
            for (int i = 0; i < ls.size() - 1; i++) {
                if (ls.get(i).equals(l)) {
                    ls.remove(ls.size() - 1);
                    break;
                }
            }
            l.remove(l.size() - 1);
            return;
        }

        int diff = target - value;
        for (int j = index + 1; j < candidates.length; j++) {
            recursion(candidates, diff, j, ls, l);
        }
        l.remove(l.size() - 1);
    }
}
