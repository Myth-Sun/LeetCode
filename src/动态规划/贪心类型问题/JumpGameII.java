package 动态规划.贪心类型问题;

/**
 * 跳跃游戏II 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4] 输出: 2 解释: 跳到最后一个位置的最小跳跃数是 2。 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JumpGameII {

  public int jump(int[] nums) {
    int n = nums.length;
    //跳跃次数
    int jumpCount = 0;
    //位置i
    int i = 0;
    //从上个位置（nums[i-1]）最远可以到达的位置
    int end = 0;
    //在i-end之间最远可以到达的位置
    int farthest = 0;

    //因为题目假设总是可以到达数组的最后一个位置，所以最后一次跳跃时end总是等于n-1，
    // 当i等于n-1时，jumpCount便多算一次，所以遍历时应该为i<n-1
    for (; i < n - 1; i++) {
      farthest = Math.max(farthest, nums[i] + i);
      if (end == i) {
        end = farthest;
        jumpCount++;
      }
    }
    return jumpCount;
  }

  public static void main(String[] args) {
    JumpGameII jumpGame = new JumpGameII();
    int[] nums = {2, 3, 1, 1, 4};
    int jump = jumpGame.jump(nums);
    System.out.println(jump);
  }
}
