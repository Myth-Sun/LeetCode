package 动态规划.背包类型问题;

import java.util.Arrays;

/** 零钱兑换II （完全背包问题，可以使用的每个物品的数量无限）
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10] 
 * 输出: 1
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额)<= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 */
public class CoinChange {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //dp[i][j]:若只使用 coins 中的前 i 个硬币的面值，若想凑出金额 j，有 dp[i][j] 种凑法。
        int dp[][] = new int[n + 1][amount + 1];

        //base case:
        // dp[0][..]=0 不使用任何硬币，无法凑出任何金额
        // dp[..][0]=1 凑出目标金额为0，此时只有“无为而治”一种凑法
        for (int[] row : dp)
            Arrays.fill(row, 0);
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    //金额数小于硬币面值，选择不装入该硬币
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //不使用第i个硬币情况下的值+使用第i个硬币情况下的值
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        return dp[n][amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {10};
        int change = coinChange.change(10, coins);
        System.out.println(change);
    }
}
