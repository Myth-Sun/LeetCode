package 数组;

/*
1004. 最大连续1的个数 III
给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

返回仅包含 1 的最长（连续）子数组的长度。

 

示例 1：

输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释：
[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。
示例 2：

输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 

提示：

1 <= A.length <= 20000
0 <= K <= A.length
A[i] 为 0 或 1 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//采用滑动窗口思路
public class LongestOnes {
    public int longestOnes(int[] A, int K) {
        int result = 0;
        int zero = 0, left = 0, right = 0;
        int n = A.length;
        while (right < n) {
            if (A[right] == 0) {
                zero++;
            }
            while (zero > K) {
                if (A[left] == 0) {
                    zero--;
                }
                left++;
            }
            if (zero == K || right == n - 1) {
                result = Math.max(result, right - left + 1);
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestOnes longestOnes = new LongestOnes();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 3;
        int i = longestOnes.longestOnes(nums, k);
        System.out.println(i);
    }
}
