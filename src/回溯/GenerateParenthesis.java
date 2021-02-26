package 回溯;

import java.util.LinkedList;
import java.util.List;

/*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]
 

提示：

1 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    List<String> ans = new LinkedList<>();
    StringBuilder builder = new StringBuilder();
    int n, left = 0, right = 0;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtracking();
        return ans;
    }
    //右括号数小于左括号数才能放置右括号
    //回溯分别防止左右括号
    public void backtracking() {
        if (builder.length() == 2 * n) {
            ans.add(builder.toString());
            return;
        }

        if (left < n) {
            builder.append('(');
            left++;
            backtracking();
            left--;
            builder.deleteCharAt(builder.length() - 1);
        }
        if (left > right) {
            builder.append(')');
            right++;
            backtracking();
            right--;
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        int n = 3;
        System.out.println(g.generateParenthesis(n));
    }
}
