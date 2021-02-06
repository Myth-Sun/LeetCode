package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
491. 递增子序列
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/increasing-subsequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//非有序序列中判断回溯过程中同一树层是否已经遍历过某个元素，可以在回溯方法for循环前声明一个map或者数组记录是否已经被遍历
public class FindSubsequences {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        backtracking(0);
        return ans;
    }

    public void backtracking(int startIndex) {
        if (path.size() > 1) {
            ans.add(new ArrayList<>(path));
        }

//        Map<Integer, Boolean> map = new HashMap<>();
        int[] temp = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
//            if ((map.containsKey(nums[i]) && map.get(nums[i]) == false)
            if (temp[nums[i] + 100] == 1
                    || (path.size() > 0 && nums[i] < path.get(path.size() - 1))) {

                continue;
            }
            path.add(nums[i]);
//            map.put(nums[i], true);
            temp[nums[i] + 100] = 1;
            backtracking(i + 1);
            path.remove(path.size() - 1);
//            map.put(nums[i], false);
        }
    }

    public static void main(String[] args) {
        FindSubsequences findSubsequences = new FindSubsequences();
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> subsequences = findSubsequences.findSubsequences(nums);
        System.out.println(subsequences);
    }
}
