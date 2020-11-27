package 动态规划.其他经典问题;

import java.util.HashMap;
import java.util.Map;

/**
 * 鸡蛋掉落
 * 你将获得K个鸡蛋，并可以使用一栋从1到N共有 N层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层F ，满足0 <= F <= N 任何从高于 F的楼层落下的鸡蛋都会碎，从F楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层X扔下（满足1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 * <p>
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：K = 3, N = 14
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= 100
 * 1 <= N <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//leetcode 提交超时
public class SuperEggDrop {
    Map<String, Integer> memo = new HashMap<>();

    public int superEggDrop(int K, int N) {
        return dp1(K, N);
    }

    public int dp(int K, int N) {
        //状态：当前拥有鸡蛋数K，需要测试的楼层数N
        //选择：选择哪层楼扔鸡蛋
        //base case:
        if (N == 0)//楼层数为0，不需要扔鸡蛋
            return 0;
        if (K == 1)//当前拥有鸡蛋数为1，只能线性扫描所有楼层
            return N;
        String key = K + "," + N;
        if (memo.containsKey(key))
            return memo.get(key);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            //第i层鸡蛋碎了，鸡蛋个数K-1，搜索楼层区间变为[1..i-1]
            //第i层鸡蛋美穗，鸡蛋个数为K，搜索楼层区间变为[i+1..N],i+1层相当于第一层
            res = Math.min(res, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1);
        }
        memo.put(key, res);
        return res;
    }

    //二分查找优化后的算法
    public int dp1(int K, int N) {
        //状态：当前拥有鸡蛋数K，需要测试的楼层数N
        //选择：选择哪层楼扔鸡蛋
        //base case:
        if (N == 0)//楼层数为0，不需要扔鸡蛋
            return 0;
        if (K == 1)//当前拥有鸡蛋数为1，只能线性扫描所有楼层
            return N;
        String key = K + "," + N;
        if (memo.containsKey(key))
            return memo.get(key);
        int res = Integer.MAX_VALUE;
        int l = 1, h = N;
        while (l <= h) {
            int mid = (l + h) / 2;
            int broken = dp(K - 1, mid - 1);
            int notBroken = dp(K, N - mid);
            if (broken > notBroken) {
                h = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                l = mid + 1;
                res = Math.min(res, notBroken + 1);
            }
        }
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        SuperEggDrop superEggDrop = new SuperEggDrop();
        int i = superEggDrop.superEggDrop(4, 5000);
        System.out.println(i);
    }
}
