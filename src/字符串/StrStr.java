package 字符串;

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

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        String haystack = "babba", needle = "bbb";
        int i = strStr.strStr(haystack, needle);
        System.out.println(i);
    }
}
