package 数组;

/*
59. 螺旋矩阵 II
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。



示例 1：


输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：

输入：n = 1
输出：[[1]]


提示：

1 <= n <= 20
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1, i = 1;
        int[][] matrix = new int[n][n];
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = i;
                i++;
            }
            rowBegin++;
            for (int j = rowBegin; j <= rowEnd; j++) {
                matrix[j][colEnd] = i;
                i++;
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    matrix[rowEnd][j] = i;
                    i++;
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    matrix[j][colBegin] = i;
                    i++;
                }
            }
            colBegin++;
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                System.out.println(matrix[j][k]);
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        GenerateMatrix g = new GenerateMatrix();
        int n = 3;
        g.generateMatrix(n);
    }
}
