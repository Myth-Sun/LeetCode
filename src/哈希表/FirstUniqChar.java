package 哈希表;

/*
剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = "" 
返回 " "
 

限制：

0 <= s 的长度 <= 50000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            array[c - 'a']++;
        }
        for (char c : chars) {
            if (array[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        FirstUniqChar f = new FirstUniqChar();
        String s = "leetcode";
        System.out.println(f.firstUniqChar(s));
    }
}
