package 动态规划.贪心类型问题;

/**
 * 跳跃游戏 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: [2,3,1,1,4] 输出: true 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。 示例2:
 * <p>
 * 输入: [3,2,1,0,4] 输出: false 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class JumpGameI {

  //转化为求最多可以跳到多远的问题
  public boolean canJump(int[] nums) {
    //当前情况下全局最优的可以到达的最远距离
    int farthest = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      //迭代计算全局最优最远距离
      farthest = Math.max(farthest, nums[i] + i);
      // nums[i]为0时
      if (farthest == i && i != n - 1) {
        return false;
      }
    }
    //最远可到达距离大于等于数组长度时则必然可以到达数组最后一个位置
    return farthest >= n - 1;
  }

  public static void main(String[] args) {
    JumpGameI jumpGame = new JumpGameI();
    int[] nums = {0, 1};
    boolean b = jumpGame.canJump(nums);
    System.out.println(b);
  }
}
