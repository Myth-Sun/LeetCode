package 字符串;

import java.util.HashMap;
import java.util.Map;

/*
409. 最长回文串
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int ans = 0;
        for (Character c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : map.keySet()) {
            ans += (map.get(c) / 2) * 2;
        }
        if (ans < s.length()) {
            ans++;
        }
        return ans;
    }
}
