package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
51. N 皇后
n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。

每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。


示例 1：
输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。

示例 2：

输入：n = 1
输出：[["Q"]]


提示：

1 <= n <= 9
皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens {
    List<List<String>> ans = new ArrayList<List<String>>();
    char[][] chessboard;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i],'.');
        }
        backtracking(0);
        return ans;
    }

    public void backtracking(int row) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(chessboard[i]));
            }
            ans.add(new ArrayList<>(temp));
        }
        //遍历每一行
        for (int i = 0; i < n; i++) {
            if(!check(row,i))
                continue;
            chessboard[row][i] = 'Q';
            backtracking(row + 1);
            chessboard[row][i] = '.';
        }
    }

    public boolean check(int row, int col) {
        //检查同一列是否存在冲突
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q')
                return false;
        }
        //检查左斜方向是否存在冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        //检查右斜方向是否存在冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        int n = 1;
        List<List<String>> lists = solveNQueens.solveNQueens(n);
        System.out.println(lists);
    }
}
