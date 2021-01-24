package 字符串;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (char c : chars) {
            if (c == ' ')
                len += 2;
        }
        char[] newStr = new char[len];
        int point = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                newStr[point++] = '%';
                newStr[point++] = '2';
                newStr[point++] = '0';
            }else{
                newStr[point++] = chars[i];
            }
        }
        return new String(newStr,0,point);
    }

    public static void main(String[] args) {
        String str = "We are  happy.";
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = replaceSpace.replaceSpace(str);
        System.out.println(s);
    }
}
