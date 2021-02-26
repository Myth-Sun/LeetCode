package 回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
剑指 Offer 38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。


示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

限制：

1 <= s 的长度 <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutation {
    List<String> ans = new LinkedList<>();
    StringBuilder builder = new StringBuilder();
    char[] chars;
    boolean[] isUsed;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        Arrays.sort(chars);
        isUsed = new boolean[chars.length];
        backtracking();
        String[] strAns = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            strAns[i] = ans.get(i);
        }
        return strAns;
    }

    public void backtracking() {
        if (builder.length() == chars.length) {
            ans.add(builder.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1] && isUsed[i - 1] == false) {
                continue;
            }
            if (isUsed[i] != true) {
                isUsed[i] = true;
                builder.append(chars[i]);
                backtracking();
                isUsed[i] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        String s = "abca";
        p.permutation(s);
    }
}
