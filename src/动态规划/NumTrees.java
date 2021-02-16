package 动态规划;

/*
96. 不同的二叉搜索树
给定一个整数 n，求以1 ...n为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumTrees {
    //dp[3]=1为头节点搜索树的数量+2为头节点搜索树的数量+3为头节点搜索树的数量
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        int n = 3;
        System.out.println(numTrees.numTrees(n));
    }
}
