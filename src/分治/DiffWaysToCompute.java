package 分治;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
241. 为运算表达式设计优先级
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

示例 1:

输入: "2-1-1"
输出: [0, 2]
解释:
((2-1)-1) = 0
(2-(1-1)) = 2
示例 2:

输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
 */
public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> partition = partition(input);
        Collections.sort(partition);
        return partition;
    }

    public List<Integer> partition(String input) {
        List<Integer> ans = new LinkedList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            ans.add(Integer.parseInt(input));
            return ans;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> lefts = partition(input.substring(0, i));
                List<Integer> rights = partition(input.substring(i + 1));
                for (int left : lefts) {
                    for (int right : rights) {
                        if (input.charAt(i) == '+') {
                            ans.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            ans.add(left - right);
                        } else {
                            ans.add(left * right);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
