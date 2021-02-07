package 回溯;

import java.util.LinkedList;
import java.util.List;
/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    int[] nums;
    boolean[] isUsed;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.isUsed = new boolean[nums.length];
        backtracking();
        return ans;
    }

    public void backtracking() {
        if (path.size() == nums.length) {
            ans.add(new LinkedList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            path.add(nums[i]);
            isUsed[i] = true;
            backtracking();
            isUsed[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute1 = permute.permute(nums);
        System.out.println(permute1);
    }
}
