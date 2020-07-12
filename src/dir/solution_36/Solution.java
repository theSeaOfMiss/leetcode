package dir.solution_36;

// 重点
// 3x3可以划分为(row / 3) * 3 + columns / 3;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 数字1-9在每一行只能出现一次。
        int[][] row = new int[9][9];
        // 数字 1-9 在每一列只能出现一次。
        int[][] column = new int[9][9];
        // 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
        int[][][] area = new int[9][3][3];
        int digit;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    digit = board[i][j] - '1';

                    // 检测行
                    if (row[digit][j] == 0) row[digit][j] = 1;
                    else return false;

                    // 检测列
                    if (column[digit][i] == 0) column[digit][i] = 1;
                    else return false;

                    // 检测3x3区域
                    if (area[digit][isWhere(i)][isWhere(j)] == 0) area[digit][isWhere(i)][isWhere(j)] = 1;
                    else return false;
                }
            }
        }
        return true;
    }
    private static int isWhere(int para) {
        if (0 <= para && para < 3) {
            return 0;
        }
        if (3 <= para && para < 6) {
            return 1;
        }
        if (6 <= para && para < 9) {
            return 2;
        }
        return -1;
    }
}
