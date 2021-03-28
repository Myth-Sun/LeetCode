package 数组;

import java.util.ArrayList;
/*
剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。



示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]


限制：

1 <= target <= 10^5
 */
//滑动窗口
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int start = 1, end = 2, curSum = 3;
        ArrayList<int[]> res = new ArrayList<>();
        while (end < target) {
            if (curSum < target) {
                end++;
                curSum += end;
            } else if (curSum > target) {
                curSum -= start;
                start++;
            } else {
                int[] temp = new int[end - start + 1];
                for (int i = start; i <= end; i++) {
                    temp[i - start] = i;
                }
                res.add(temp);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
