package 动态规划.背包类型问题;

import java.util.Arrays;

/**
 * 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * 示例2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        //不能被2整除，无法分割成两个元素和相等的子集
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        int N = nums.length;
        //dp[i][j] : 前i个物品，当前背包容量为j
        boolean dp[][] = new boolean[N + 1][sum + 1];

        //base case:dp[0][..]=false;没有物品可选，无法装满包
        //          dp[..][0]=true;背包容量为0，相当于装满包
        for (int i = 0; i < sum + 1; i++)
            dp[0][i] = false;
        for (int i = 0; i < N + 1; i++)
            dp[i][0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0)//背包容量无法容纳第i个物品
                    dp[i][j] = dp[i - 1][j];
                else {//装入或者不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[N][sum];
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        //不能被2整除，无法分割成两个元素和相等的子集
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        int[] nums = {1, 5, 11, 5};
        boolean result = canPartition.canPartition1(nums);
        System.out.println(result);
    }
}
