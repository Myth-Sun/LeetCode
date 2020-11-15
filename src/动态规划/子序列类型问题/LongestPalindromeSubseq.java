package 动态规划.子序列类型问题;

import java.util.Arrays;

/** 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, 0);

        //base case
        //当i=j时，只有一个字符，最长回文子序列长度是1
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        //求dp[i][j]需要知道dp[i+1][j-1],dp[i][j-1],dp[i+1][j],为保证每次计算dp[i][j]，左下右的位置都已被计算，只能斜着或泛着遍历
        //反着遍历
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubseq l = new LongestPalindromeSubseq();
        int result = l.longestPalindromeSubseq("bbbab");
        System.out.println(result);
    }
}
