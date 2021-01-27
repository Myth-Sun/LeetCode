package 字符串;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr {
    //滑动窗口
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if (len == 0) {
            return 0;
        }
        int haystackLen = haystack.length();
        int i = 0, j = len - 1;
        while (i < haystackLen && j < haystackLen) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                i++;
                j++;
            } else {
                int curLen = 0;
                int needlePoint = 0;
                while (i < haystackLen && needlePoint < len && haystack.charAt(i) == needle.charAt(needlePoint)) {
                    curLen++;
                    needlePoint++;
                    i++;
                }
                if (curLen == len)
                    return (i - len);
                i = (i - curLen + 1);
            }
        }
        return -1;
    }

    //KMP解法
    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int hayPoint = 0, needlePoint = 0;
        while (hayPoint < haystack.length()) {
            while (needlePoint > 0 && needle.charAt(needlePoint) != haystack.charAt(hayPoint)) {
                needlePoint = next[needlePoint - 1];
            }
            if (haystack.charAt(hayPoint) == needle.charAt(needlePoint)) {
                needlePoint++;
            }
            if (needlePoint == needle.length()) {
                return hayPoint - needle.length() + 1;
            }

            hayPoint++;
        }
        return -1;
    }

    public int[] getNext(String needle) {
        int j = 0;
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        String haystack = "hello", needle = "hello";
        int i = strStr.strStr1(haystack, needle);
        System.out.println(i);
    }
}
