package 字符串;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {
    //⭐ 数字位数不一致时的补零操作
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int add1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int add2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int res = add1 + add2 + add;
            stringBuilder.append(res % 10);
            add = res / 10;
            i--;
            j--;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String nums1 = "167";
        String nums2 = "5";
        String s = addStrings.addStrings(nums1, nums2);
        System.out.println(s);
    }
}
