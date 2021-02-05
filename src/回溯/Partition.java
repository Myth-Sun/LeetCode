package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
131. 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入:"aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Partition {
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> path = new ArrayList<>();
    String s;


    public List<List<String>> partition(String s) {
        this.s = s;
        backtracking(0);
        return ans;
    }

    public void backtracking(int startIndex) {
        if (startIndex >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i+1);
            if (!check(substring)) {
                continue;
            }
            path.add(substring);

            backtracking(i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean check(String s) {
        if (s.equals("")) {
            return false;
        }
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        String s = "aab";
        List<List<String>> partition1 = partition.partition(s);
        System.out.println(partition1);
    }
}
