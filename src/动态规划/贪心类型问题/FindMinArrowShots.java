package 动态规划.贪心类型问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 x_start，x_end， 且满足 x_start≤ x ≤
 * x_end，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * 给你一个数组 points ，其中 points [i] = [x_start,x_end] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]] 输出：2 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11
 * 射爆另外两个气球 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]] 输出：4 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]] 输出：2 示例 4：
 * <p>
 * 输入：points = [[1,2]] 输出：1 示例 5：
 * <p>
 * 输入：points = [[2,3],[2,3]] 输出：1
 * <p>
 * 提示：
 * <p>
 * 0 <= points.length <= 104 points[i].length == 2 -2^31 <= x_start <x_end <= 2^31 - 1
 */
public class FindMinArrowShots {

  //等价于求最多不重叠子区间
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) {
      return 0;
    }
    //对区间按end排序
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });
    //最少有一个区间不相交
    int count = 1;
    int end = points[0][1];
    for (int[] interval : points) {
      int start = interval[0];
      //只有区间的start大于上一区间的end这两个区间才不相交
      if (start > end) {
        end = interval[1];
        count++;
      }
    }
    return count;
  }
}
