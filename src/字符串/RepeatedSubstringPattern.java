package 字符串;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedSubstringPattern {
    //枚举方式
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        boolean isMatch = false;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                isMatch = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch == true) {
                    return true;
                }
            }
        }
        return false;
    }

    //KMP方式
    public boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        int[] next = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        boolean isMatch = next[n - 1] != 0 && n % (n - next[n - 1]) == 0;
        return isMatch;
    }


    public static void main(String[] args) {
        RepeatedSubstringPattern r = new RepeatedSubstringPattern();
        String s = "abac";
        boolean b = r.repeatedSubstringPattern1(s);
        System.out.println(b);
    }
}
