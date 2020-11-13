package 动态规划.子序列类型问题;

import java.util.Arrays;

/**
 * "最长公共子序列"
 * 给定两个字符串text1 和text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * 示例 1:
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * <p>
 * 提示:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符
 */
public class LongestCommonSubsequence {
    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
//        return dp(text1, 0, text2, 0);
        return dp1(text1, 0, text2, 0);
    }

    //自底向上的迭代动态规划思路
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化base case:dp[0][..]=dp[..][0]=0
        for (int i = 0; i < n + 1; i++)
            dp[0][i] = 0;
        for (int j = 0; j < m + 1; j++)
            dp[j][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    //递归方式
    public int dp(String text1, int i, String text2, int j) {
        //base case （当遍历完其中一个字符串时）
        if (i == text1.length() || j == text2.length())
            return 0;
        if (text1.charAt(i) == text2.charAt(j))
            return 1 + dp(text1, i + 1, text2, j + 1);
        else {
            return Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
        }
    }

    //自顶向下带备忘录的动态规划思路
    public int dp1(String text1, int i, String text2, int j) {
        //base case （当遍历完其中一个字符串时）
        if (i == text1.length() || j == text2.length())
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (text1.charAt(i) == text2.charAt(j))
            memo[i][j] = 1 + dp(text1, i + 1, text2, j + 1);
        else {
            memo[i][j] = Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
        }
        return memo[i][j];
    }


    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        int i = l.longestCommonSubsequence1("abc", "abc");
        System.out.println(i);
    }
}
