package 动态规划.其他经典问题;

/**
 * 实现 strStr() 函数。
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与C语言的strstr()以及 Java的indexOf()定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KMP {
    // haystack:目标字符串 needle：待查取的字符串
    public int strStr(String haystack, String needle) {
        int M = needle.length();
        if (M == 0)
            return 0;
        int N = haystack.length();
        // dp[状态][字符]=下个状态
        // 一共有M+1个状态，最后一个状态为终止状态
        // 数组默认初始化为0
        int[][] dp = new int[M][256];
        // base case：状态0遇到needle[0]才能从状态0转至状态1
        dp[0][needle.charAt(0)] = 1;
        //影子状态X：与当前状态前缀相同的状态
        //影子状态初始化为0
        int X = 0;
        //当前状态
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 256; j++) {
                if (needle.charAt(i) == j)
                    dp[i][j] = i + 1;
                else
                    dp[i][j] = dp[X][j];
            }
            X = dp[X][needle.charAt(i)];
        }

        //查找haystack中是否有needle字符串
        //needle的初始状态为0
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][haystack.charAt(i)];
            if (j == M)
                return i - M + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String haystack = "aaaaa", needle = "bba";
        System.out.println(kmp.strStr(haystack, needle));
    }
}
