package 数组;

/*
剑指 Offer 12. 矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

 

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
 

提示：

1 <= board.length <= 200
1 <= board[i].length <= 200
注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {
    boolean[][] isVisited;
    char[] chars;
    int m, n;
    //遍历方向:上下左右
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        chars = word.toCharArray();
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtracking(int row, int col, int k) {
        if (board[row][col] != chars[k]) {
            return false;
        }
        if (k == chars.length - 1) {
            return true;
        }
        isVisited[row][col] = true;
        boolean res = false;
        for (int i = 0; i < directions.length; i++) {
            int nRow = row + directions[i][0];
            int nCol = col + directions[i][1];
            if (nRow >= 0 && nCol >= 0 && nRow <= m - 1 && nCol <= n - 1) {
                if(!isVisited[nRow][nCol]){
                    res = backtracking(nRow, nCol, k + 1);
                    if (res == true) {
                        break;
                    }
                }
            }
        }
        isVisited[row][col] = false;
        return res;
    }

}
