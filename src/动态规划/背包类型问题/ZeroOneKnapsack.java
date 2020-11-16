package 动态规划.背包类型问题;

import java.util.Arrays;

/**
 * 0-1背包问题
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 * 
 * 举个简单的例子，输入如下：
 * 
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * 算法返回 6，选择前两件物品装进背包，总重量 3 小于W，可以获得最大价值 6。
 * 
 * 题目中的物品不可分割，要么装进包里，要么不装，不能切开装进去。
 */
public class ZeroOneKnapsack {

    //N个物品，可载重量为W，wt为物品重量列表,val为物品价值列表
    public int knapsack(int N, int W, int[] wt, int[] val) {
        int dp[][] = new int[N + 1][W + 1];
        //base case:dp[0][..]=dp[..][0]=0,没有物品或者背包没有空间时，能装的最大价值为0
        for (int[] row : dp)
            Arrays.fill(row, 0);

        for (int i = 1; i <= N; i++) {//第i个物品
            for (int j = 1; j <= W; j++) {//背包可载重
                if (j - wt[i - 1] < 0) {
                    //当前背包容量装不下该物品，选择不装入
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //选择装入或者不装入
                    //装入情况：在剩余重量j - wt[i - 1]的限制下能装的最大价值，在加上第i个物品的价值val[i-1]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
        int N = 3, W = 4;
        int[] wt = {2, 1, 3}, val = {4, 2, 3};
        int knapsack = zeroOneKnapsack.knapsack(N, W, wt, val);
        System.out.println(knapsack);
    }
}
