package 动态规划.其他经典问题;

/**
 * 4键键盘 假设您有一个带有以下按键的特殊键盘:
 * <p>
 * 键1: (A):在屏幕上打印一个‘A’。
 * <p>
 * 键2: (Ctrl-A):选择整个屏幕。
 * <p>
 * 键3: (Ctrl-C):将选择复制到缓冲区。
 * <p>
 * 键4: (Ctrl-V):在屏幕上打印缓冲区，在已经打印的内容后附加它。
 * <p>
 * 现在，你只能按键盘N次(用上面四个键)，找出你能在屏幕上打印的‘A’的最大个数。
 * <p>
 * 例1:
 * <p>
 * 输入:N = 3 输出:3 解释: 我们最多可以在屏幕上显示三个'A'，通过如下顺序按键: A,A,A
 * <p>
 * <p>
 * 例2:
 * <p>
 * 输入:N = 7 产出:9 解释: 我们最多可以通过按以下键序列在屏幕上获得九个'A': A，A，A，Ctrl A，Ctrl C，Ctrl V，Ctrl V
 * <p>
 * <p>
 * 注意:
 * <p>
 * 1 <= N <= 50 答案将在32位有符号整数范围内。
 */
public class MaxA {

  //N：一共敲击的次数
  public int maxA(int N) {
    int[] dp = new int[N + 1];
    dp[0] = 0;
    //状态：剩余的敲击次数n
    //选择：第几次按下CTRL A
    //最优按键序列：1，一直按A：A,A,...A（当N比较小时）
    //           2. 先按A再C-A,C-C,C-V,C-V,...,C-A,C-C,C-V,...C-V（当N比较大时）
    for (int i = 1; i <= N; i++) {
      //当按下A时
      dp[i] = dp[i - 1] + 1;
      //j：C-V的起点
      //全选和复制的起点是dp[j-2],连续粘贴i-j次，此时屏幕上共有dp[j-2]*(i-j+1)个A（算上dp[j-2]）
      for (int j = 2; j < i; j++) {
        dp[i]=Math.max(dp[i],dp[j-2]*(i-j+1));
      }
    }
    return dp[N];
  }

  public static void main(String[] args) {
    MaxA maxA=new MaxA();
    int i = maxA.maxA(7);
    System.out.println(i);
  }
}
