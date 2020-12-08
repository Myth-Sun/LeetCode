package 动态规划.其他经典问题;

/**
 * 买卖股票的最佳时机 IV
 * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= k <= 109
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit {
    public int maxProfit(int K, int[] prices) {
        //状态：
        //  i:天数；k:至今最多交易次数；rest:当前持有状态，1表示持有，0表示没有持有
        //选择：
        //  买入，卖出，无操作 (卖出不算交易)
        //三维dp数组：dp[][][]
        //base case:
        //  dp[-1][k][0]=0          i=-1意味着还没有开始，此时利润为0
        //  dp[-1][k][1]=-infinity  还没有开始不可能持有股票，用负无穷表示不可能
        //  dp[i][0][0]=0           k=0表示不允许交易，此时利润为0
        //  dp[i][0][1]=-infinity           k=0不允许交易，此时不可能持有股票，用负无穷大表示不可能
        int N = prices.length;
        //没有股票，返回0
        if (N == 0) {
            return 0;
        }
        int[][][] dp = new int[N][K + 1][2];

        //状态转移方程
        //  dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k-1][1]+prices[i])
        //                      昨天没有持有，今天rest  昨天持有，今天sell
        //  dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
        //                      昨天持有，今天rest   昨天没有持有,今天buy
        for (int i = 0; i < N; i++) {
            for (int k = K; k >= 1; k--) {//k倒序遍历
                if (i == 0) {
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                } else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
        }
        return dp[N - 1][K][0];
    }

    /**
     * 买卖股票的最佳时机（简单）
     * 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意：你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //当K=1，即只交易一次
    public int maxProfitK1(int[] prices) {
        int N = prices.length;
        //没有股票，返回0
        if (N == 0) {
            return 0;
        }
        //dpI0:还未开始，此时利润为0
        //dpI1:还未开始，不可能持有股票，用Integer.MIN_VALUE表示不可能
        int dpI0 = 0, dpI1 = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dpI0 = Math.max(dpI0, dpI1 + prices[i]);
            dpI1 = Math.max(dpI1, -prices[i]);
        }
        return dpI0;
    }

    /**
     * 买卖股票的最佳时机 II
     * 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例3:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * <p>
     * 提示：
     * <p>
     * 1 <= prices.length <= 3 * 10 ^ 4
     * 0 <= prices[i]<= 10 ^ 4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxProfitKInf(int[] prices) {
        //尽可能地完成交易-->K为正无穷，此时可以认为K和K-1是一样的
        int N = prices.length;
        //没有股票，返回0
        if (N == 0)
            return 0;

        int dpI0 = 0, dpI1 = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int temp = dpI0;
            dpI0 = Math.max(dpI0, dpI1 + prices[i]);
            dpI1 = Math.max(dpI1, temp - prices[i]);
        }
        return dpI0;
    }

    /**
     * 309. 最佳买卖股票时机含冷冻期
     * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
     * <p>
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * <p>
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 示例:
     * <p>
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxProfitKInfWithCool(int[] prices) {
        //尽可能地完成交易-->K为正无穷，此时可以认为K和K-1是一样的
        int N = prices.length;
        //没有股票，返回0
        if (N == 0)
            return 0;

        int dpI0 = 0, dpI1 = Integer.MIN_VALUE;
        int dpPre0 = 0;//代表dp[i-2][0]
        for (int i = 0; i < N; i++) {
//            由于冷冻期为1天，因此第i天选择buy时，要从i-2的状态转移，而不是i-1
//            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
//            dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
            int temp = dpI0;
            dpI0 = Math.max(dpI0, dpI1 + prices[i]);
            dpI1 = Math.max(dpI1, dpPre0 - prices[i]);
            dpPre0 = temp;//下轮迭代为i+1，此时保存i-1，下轮迭代正好差2
        }
        return dpI0;
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * <p>
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     * <p>
     * 示例 1:
     * <p>
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * 注意:
     * <p>
     * 0 < prices.length <= 50000.
     * 0 < prices[i] < 50000.
     * 0 <= fee < 50000.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxProfitKInfWithFee(int[] prices, int fee) {
        //尽可能地完成交易-->K为正无穷，此时可以认为K和K-1是一样的
        int N = prices.length;
        //没有股票，返回0
        if (N == 0)
            return 0;

        int dpI0 = 0, dpI1 = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int temp = dpI0;
            dpI0 = Math.max(dpI0, dpI1 + prices[i]);
            dpI1 = Math.max(dpI1, temp - prices[i] - fee);//买入时支付手续费
        }
        return dpI0;
    }

    /**
     * 123. 买卖股票的最佳时机 III
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
     * <p>
     * 注意:你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例1:
     * <p>
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxProfitK2(int[] prices) {
        int N = prices.length;
        //没有股票，返回0
        if (N == 0) {
            return 0;
        }
        int K = 2;
        int[][][] dp = new int[N][K + 1][2];
        // 还没有开始，此时收益为0；还没有开始，不可能持有股票，用Integer.MIN_VALUE表示不可能
        int dpI20 = 0, dpI21 = Integer.MIN_VALUE;
        int dpI10 = 0, dpI11 = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            dpI20 = Math.max(dpI20, dpI21 + prices[i]);
            dpI21 = Math.max(dpI21, dpI10 - prices[i]);
            dpI10 = Math.max(dpI10, dpI11 + prices[i]);
            dpI11 = Math.max(dpI11, -prices[i]);
        }
        return dpI20;
    }


    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int k = 2;
        int[] prices = {1, 2, 3, 4, 5};
        int fee = 2;
//        int i = maxProfit.maxProfit(k, prices);
//        int i = maxProfit.maxProfitKInfWithCool(prices);
//        int i = maxProfit.maxProfitKInfWithFee(prices, fee);
        int i = maxProfit.maxProfitK2(prices);
        System.out.println(i);

    }
}
