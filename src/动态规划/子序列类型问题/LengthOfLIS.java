package 动态规划.子序列类型问题;

import java.util.Arrays;

/**
 * “最长上升子序列”
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是[2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到O(n log n) 吗?
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(dp[i], res);
        return res;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS=new LengthOfLIS();
        int [] nums={10,9,2,5,3,7,101,18};
        int i = lengthOfLIS.lengthOfLIS(nums);
        System.out.println(i);
    }
}
