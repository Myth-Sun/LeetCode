package 回溯;

/*
37. 解数独
编写一个程序，通过填充空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字1-9在每一行只能出现一次。
数字1-9在每一列只能出现一次。
数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
空白格用'.'表示。

提示：

给定的数独序列只包含数字1-9和字符'.'。
你可以假设给定的数独只有唯一解。
给定数独永远是9x9形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sudoku-solver
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveSudoku {
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        backtracking();
    }

    public boolean backtracking() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if(board[row][col]!='.')
                    continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(row,col,c)) {
                        board[row][col] = c;
                        if (backtracking()) {
                            return true;
                        }
                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int row, int col,char val) {

        for (int i = 0; i < 9; i++) {
            //判断同一行是否满足
            if(board[row][i]==val)
                return false;
            //判断同一列是否满足
            if (board[i][col] == val) {
                return false;
            }
        }

        //判断3*3宫格是否满足
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for (int i = rowStart; i < rowStart+3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

}
