package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
90. 子集 II
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsWithDup {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    boolean[] isUsed;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        isUsed = new boolean[nums.length];
        backtracking(0);
        return ans;
    }

    public void backtracking(int startIndex) {
        ans.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i-1]) {
                continue;
            }
            path.add(nums[i]);
            isUsed[i] = true;
            backtracking(i + 1);
            isUsed[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets1 = subsets.subsets(nums);
        System.out.println(subsets1);
    }
}
