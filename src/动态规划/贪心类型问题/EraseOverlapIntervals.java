package 动态规划.贪心类型问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 无重叠区间 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class EraseOverlapIntervals {

  public int eraseOverlapIntervals(int[][] intervals) {
    return intervals.length - intervalSchedule(intervals);
  }

  //求最多有多少区间不相交
  public int intervalSchedule(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    //对区间按end排序
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });
    //最少有一个区间不相交
    int count = 1;
    int end = intervals[0][1];
    for (int[] interval : intervals) {
      int start = interval[0];
      //只有区间的start大于等于上一区间的end这两个区间才不相交
      if (start >= end) {
        end = interval[1];
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1, 2}, {2, 3},{3,4},{4,5}};
    EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
    int i = eraseOverlapIntervals.eraseOverlapIntervals(intervals);
    System.out.println(i);
    int i1 = eraseOverlapIntervals.intervalSchedule(intervals);
    System.out.println(i1);
  }
}
