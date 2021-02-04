package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
40. 组合总和 II
给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。

candidates中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例1:

输入: candidates =[10,1,2,7,6,1,5], target =8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例2:

输入: candidates =[2,5,2,1,2], target =5,
所求解集为:
[
 [1,2,2],
 [5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    int[] candidates;
    int target, sum = 0;
    boolean[] isUsed;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        //标记同一层和同一路径上是否使用过某元素
        this.isUsed = new boolean[candidates.length];
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
        for (int i = startIndex; i < candidates.length; i++) {
            //isUsed[i - 1] == false说明此时同一层已经使用过该元素，跳过
            //isUsed[i - 1] == true说明此时同一路径已经使用过该元素
            if (i > 0 && candidates[i] == candidates[i - 1] && isUsed[i - 1] == false) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            isUsed[i] = true;
            backtracking(i + 1);
            path.remove(path.size() - 1);
            sum -= candidates[i];
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> lists = combinationSum2.combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
