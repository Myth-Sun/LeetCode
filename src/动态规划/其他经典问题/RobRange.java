package 动态规划.其他经典问题;

/**
 * 打家劫舍II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 *
 * 示例1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RobRange {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        //首尾房间相连，意味首尾房间不能同时被抢，此时存在三种情况：
        //  1.首尾都不抢
        //  2.第一间房间被抢，最后一间房间不抢
        //  3.最后一间房间被抢，第一间房间不被抢
        return Math.max(Math.max(robRange(nums, 1, n - 1), robRange(nums, 0, n - 2)), robRange(nums, 1, n - 2));
    }

    public int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        //分别记录dp[i+1],dp[i+2]
        int dpI1 = 0, dpI2 = 0;
        int dpI = 0;
        for (int i = end; i >= start; i--) {
            dpI = Math.max(dpI1, nums[i] + dpI2);
            dpI2 = dpI1;
            dpI1 = dpI;
        }
        return dpI;
    }

    public static void main(String[] args) {
        RobRange robRange = new RobRange();
        int[] nums={0};
        int rob = robRange.rob(nums);
        System.out.println(rob);
    }
}
