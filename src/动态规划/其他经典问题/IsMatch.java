package 动态规划.其他经典问题;

import java.util.HashMap;
import java.util.Map;

/**
 * 正则表达式匹配 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a" 输出：false 解释："a" 无法匹配 "aa" 整个字符串。 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*" 输出：true 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a'
 * 重复了一次。 示例3：
 * <p>
 * 输入：s = "ab" p = ".*" 输出：true 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b" 输出：true 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。 示例
 * 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*." 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length<= 20 0 <= p.length<= 30 s可能为空，且只包含从a-z的小写字母。 p可能为空，且只包含从a-z的小写字母，以及字符.和*。 保证每次出现字符*
 * 时，前面都匹配到有效的字符
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsMatch {

    Map<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        //s:字符串 ,p:正则表达式
        return dp(s, 0, p, 0);
    }

    public boolean dp(String s, int i, String p, int j) {
        boolean res = false;
        int m = s.length(), n = p.length();
        //正则表达式p遍历结束，如果字符串s也遍历完则匹配，否则不匹配
        if (j == n) {
            return m == i;
        }
        //字符串s已经遍历完，需要判断剩余的正则表达式p是否可以匹配空串
        if (i == m) {
            //不符合'a*b*..'的格式
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < p.length(); j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        //s[i]==p[j]
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                //'*'匹配0次或多次
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            //判断p[j+1]是否为'*'
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                //匹配0次 j+2:跳过正则表达式p的‘x*’
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        String s = "mississippi", p = "mis*is*p*.";
        boolean match = isMatch.isMatch(s, p);
        System.out.println(match);
    }
}
