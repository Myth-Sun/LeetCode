package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//利用单调队列
public class MaxSlidingWindow {
    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int num) {
            while (!deque.isEmpty() && num > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(num);
        }

        public void pop(int num) {
            if (!deque.isEmpty() && num == deque.peekFirst()) {
                deque.pollFirst();
            }
//            deque.removeFirstOccurrence(num);
        }

        public int getFirst() {
            return deque.peekFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ansIndex = 0;
        MyQueue deque = new MyQueue();
        for (int i = 0; i < k; i++) {
            deque.push(nums[i]);
        }
        System.out.println(deque.deque.toString());
        ans[0] = deque.getFirst();
        for (int i = k; i < n; i++) {
            deque.pop(nums[i - k]);
            deque.push(nums[i]);
            ansIndex++;
            ans[ansIndex] = deque.getFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 8, -7, -4, -8, 2, -6};
        int k = 2;
        MaxSlidingWindow m = new MaxSlidingWindow();
        int[] ints = m.maxSlidingWindow(nums, k);
        for (int num : ints) {
            System.out.println("num:" + num);
        }
    }
}
