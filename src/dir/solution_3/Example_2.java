package dir.solution_3;

public class Example_2 {
    public int lengthOfLongestSubstring(String s) {
        // a~z、A~Z的ASCii码值小于128；
        // last[(char)] = (int)构建k，v表；
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;   // 输出最后结果
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
