package 动态规划;

/**
 * "最大子序和"
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        //以nums[i]为结尾的“最大子数组和”为dp[i]
        int n = nums.length;
        int[] dp = new int[n];
        //base case
        dp[0] = nums[0];
        //状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, 4, -1, 2, -6, 1, 4};
        MaxSubArray maxSubArray=new MaxSubArray();
        int res = maxSubArray.maxSubArray(nums);
        System.out.println(res);
    }
}
