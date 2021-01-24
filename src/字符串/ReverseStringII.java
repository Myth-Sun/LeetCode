package 字符串;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 * <p>
 * 提示：
 * <p>
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseStringII {
    //当需要固定规律一段一段去处理字符串的时候，要想想在在for循环的表达式上做做文章。
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += (2 * k)) {
            int start = i;
            int end = Math.min(i + k - 1, s.length() - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseStringII reverseStringII = new ReverseStringII();
        String s = "abcdefg";
        int k = 2;
        String s1 = reverseStringII.reverseStr(s, k);
        System.out.println(s1);
    }
}
