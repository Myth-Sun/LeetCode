package 动态规划.其他经典问题;

import java.util.Arrays;

public class Rob {
    /**
     * 打家劫舍问题（简单）
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     * <p>
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    public int dp(int[] nums, int start) {
        if (start >= nums.length)
            return 0;
        if (memo[start] != -1)
            return memo[start];
        //盗贼在start位置有两种情况：
        // 1. 抢当前房间，下次只能从start+2位置开始
        // 2.不抢当前房间，下次从start+1位置开始
        int res = Math.max(nums[start] + dp(nums, start + 2), dp(nums, start + 1));
        memo[start] = res;
        return res;
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];//默认初始化为0
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    public int rob2U(int[] nums) {
        int n = nums.length;
        //分别记录dp[i+1],dp[i+2]
        int dpI1 = 0, dpI2 = 0;
        int dpI = 0;
        for (int i = n - 1; i >= 0; i--) {
            dpI = Math.max(dpI1, nums[i] + dpI2);
            dpI2 = dpI1;
            dpI1 = dpI;
        }
        return dpI;
    }


    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = {2, 7, 9, 3, 1};
//        int result = rob.rob(nums);
//        int result = rob.rob2(nums);
        int result = rob.rob2U(nums);
        System.out.println(result);
    }
}
