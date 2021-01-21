package 数组;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSubArrayLen {
    //滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length - 1;
        int slowIndex = 0, fastIndex = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (; fastIndex <= n; fastIndex++) {
            sum += nums[fastIndex];
            while (sum >= s) {
                int length = fastIndex - slowIndex + 1;
                if (length < res)
                    res = length;
                sum -= nums[slowIndex];
                slowIndex++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int s = 100;
        int[] nums = {};
        int res = minSubArrayLen.minSubArrayLen(s, nums);
        System.out.println(res);
    }
}
