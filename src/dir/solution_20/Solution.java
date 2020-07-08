package dir.solution_20;

import java.util.Stack;
import java.util.HashMap;

public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] bracketLeft = new char[]{'(', '{', '['};
        char[] bracketRight = new char[]{')', '}', ']'};
        int temp;
        for (int i = 0; i < bracketLeft.length; i++) {
            map.put(bracketLeft[i], i+1);
        }
        for (int i = 0; i < bracketRight.length; i++) {
            map.put(bracketRight[i], -i-1);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > 0) stack.push(map.get(s.charAt(i)));

            if (map.get(s.charAt(i)) < 0) {
                if (stack.isEmpty() || map.get(s.charAt(i)) != -stack.pop()) return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
