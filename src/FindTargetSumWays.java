/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号+和-。对于数组中的任意一个整数，你都可以从+或-中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * 示例：
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 * 提示：
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 */
public class FindTargetSumWays {
    int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        backtrack(nums, 0, S);
        return result;
    }

    //回溯算法思路（复杂度高）
    public void backtrack(int[] nums, int i, int res) {
        //满足终止条件
        if (i == nums.length) {
            if (res == 0) {
                result += 1;
            }
            return;
        }
        //做选择
        //选择-1
        res += nums[i];//使得res变为0
        backtrack(nums, i + 1, res);
        //撤销选择
        res -= nums[i];
        //选择+1
        res -= nums[i];
        backtrack(nums, i + 1, res);
        //撤销选择
        res += nums[i];
    }

    //回溯算法 （简洁版）
    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                result++;
            }
        }else{
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        int[] nums = {1, 1, 1, 1, 1};
        int S=3;
        int targetSumWays = findTargetSumWays.findTargetSumWays(nums, S);
        System.out.println(targetSumWays);
    }
}
