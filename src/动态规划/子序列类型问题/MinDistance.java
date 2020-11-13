package 动态规划.子序列类型问题;

/**
 * “编辑距离”
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 
 *
 * 示例1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class MinDistance {
//    递归写法
//    public int minDistance(String word1, String word2) {
//        int length1 = word1.length()-1;
//        int length2 = word2.length()-1;
//        return dp(length1, length2, word1, word2);
//    }
//
//    public int dp(int i, int j, String s1, String s2) {
//        //base case
//        if (i == -1)
//            return j + 1;
//        if (j == -1)
//            return i + 1;
//
//        if (s1.charAt(i) == s2.charAt(j)) {
//            return dp(i - 1, j - 1, s1, s2);//字符相同，直接跳过
//        } else {
//            return Math.min(Math.min(dp(i, j - 1, s1, s2) + 1, dp(i-1, j, s1, s2) + 1), dp(i - 1, j - 1, s1, s2) + 1);
//        }
//    }


    //动态规划写法
    //TODO 打印出最小编辑距离的具体操作
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dpTable = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            //dpTable[i][0]表示从word1[0...i]变为空字符串需要的步数，变为空字符串只需要删除字符即可，所以dpTable[i][0]的值为i
            dpTable[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dpTable[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dpTable[i][j] = dpTable[i - 1][j - 1];
                } else {
                    dpTable[i][j] = Math.min(dpTable[i - 1][j] + 1, Math.min(dpTable[i - 1][j - 1], dpTable[i][j - 1]) + 1);
                }
            }
        }
        return dpTable[m][n];
    }

    public static void main(String[] args) {
        String word1 = "rad";
        String word2 = "apple";
        MinDistance minDistance = new MinDistance();
        int res = minDistance.minDistance(word1, word2);
        System.out.println(res);
    }
}
