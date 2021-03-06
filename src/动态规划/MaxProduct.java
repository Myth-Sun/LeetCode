package 动态规划;

/*
152. 乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。



示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
//需要考虑负负得正的情况
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int minValue = nums[0], maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxValue, min = minValue;
            maxValue = Math.max(Math.max(nums[i], nums[i] * max), nums[i] * min);
            minValue = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            ans = Math.max(ans, maxValue);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] nums = {-2, 0, -1};
        int i = maxProfit.maxProfit(nums);
        System.out.println(i);
    }
}
