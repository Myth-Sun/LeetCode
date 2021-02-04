package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
39. 组合总和
给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。

candidates中的数字可以无限制重复被选取。

说明：

所有数字（包括target）都是正整数。
解集不能包含重复的组合。
示例1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
 [2,2,2,2],
 [2,3,3],
 [3,5]
]


提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    int[] candidates;
    int target, sum = 0, n;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.n = candidates.length;
        backtracking(0);
        return ans;
    }

    public void backtracking(int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < n && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(i);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, target);
        System.out.println(lists);
    }
}
