package 动态规划.其他经典问题;

/**
 *买卖股票的最佳时机 IV
 * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * 
 *
 * 提示：
 *
 * 0 <= k <= 109
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
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
        if(N==0){
            return 0;
        }
        int[][][] dp = new int[N][K + 1][2];

        //状态转移方程
        //  dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k-1][1]+prices[i])
        //                      昨天没有持有，今天rest  昨天持有，今天sell
        //  dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
        //                      昨天持有，今天rest   昨天没有持有们今天buy
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

    public static void main(String[] args) {
        MaxProfit maxProfit=new MaxProfit();
        int k=2;
        int[] prices={};
        int i = maxProfit.maxProfit(k, prices);
        System.out.println(i);
    }
}
