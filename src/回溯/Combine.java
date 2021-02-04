package 回溯;

import java.util.LinkedList;
import java.util.List;

/*
77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入:n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine {
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    List<Integer> path = new LinkedList<>();
    int k;
    int n;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        backtracking(1);
        return ans;
    }

    public void backtracking(int startIndex) {
        if (path.size() == k) {
            ans.add(new LinkedList<>(path));//!!!必须添加一个新的List对象，否则后续更改path会影响已有结果
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(i + 1);
            path.remove(path.size() - 1);//回溯
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> combine1 = combine.combine(4, 2);
        System.out.println(combine1);

    }
}
