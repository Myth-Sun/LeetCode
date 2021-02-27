package 字符串;

/*
395. 至少有 K 个重复字符的最长子串

给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。

示例 1：

输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
示例 2：

输入：s = "ababbc", k = 2
输出：5
解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。


提示：

1 <= s.length <= 104
s 仅由小写英文字母组成
1 <= k <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        return dfs(s, k);
    }

    public int dfs(String s, int k) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        String split = "";
        for (int i = 0; i < 26; i++) {
            int count = charCount[i];
            if (count > 0 && count < k) {
                split = String.valueOf((char) (i + 'a'));
                break;
            }
        }
        if (split.equals("")) {
            return s.length();
        }
        String[] split1 = s.split(split);
        int max = 0;
        for (String s1 : split1) {
            int dfs = dfs(s1, k);
            max = Math.max(dfs, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        String s = "ababbc";
        int k = 2;
        System.out.println(l.longestSubstring(s, k));
    }
}
