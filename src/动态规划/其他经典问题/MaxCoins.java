package 动态规划.其他经典问题;

/**
 * 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组nums中。
 * <p>
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得nums[left] * nums[i] * nums[right]个硬币。这里的left和right代表和i相邻的两个气球的序号。注意当你戳破了气球 i 后，气球left和气球right就变成了相邻的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * <p>
 * 你可以假设nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * <p>
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //因为nums[-1]=nums[n]=1，所以扩展数组方便遍历
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        //将nums数组复制到points数组中
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        //java int数组中的元素自动初始化为0
        //dp数组定义：dp[i][j]=x,戳破i和j之间的所有气球（开区间，不包括i,j），可以获得的最高分数为x
        //base case:dp[i][i]=0
        int[][] dp = new int[n + 2][n + 2];
        //状态转移方程：dp[i][j]=dp[i][k]+dp[k][j]+points[i]*points[k]*points[j]
        //由状态方程可知需要从下到上从左到右遍历
        for(int i=n;i>=0;i--){
            for(int j=i+1;j<=n+1;j++){
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]+points[i]*points[k]*points[j]);
                }
            }
        }
        return dp[0][n+1];
    }

    public static void main(String[] args) {
        MaxCoins maxCoins=new MaxCoins();
        int[] nums={3,1,5,8};
        int i = maxCoins.maxCoins(nums);
        System.out.println(i);
    }
}
