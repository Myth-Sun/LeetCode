package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。



示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "1111"
输出：["1.1.1.1"]
示例 4：

输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]
示例 5：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


提示：

0 <= s.length <= 3000
s 仅由数字组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/restore-ip-addresses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses {
    List<String> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    String s;
    StringBuilder builder = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        backtracking(0);
        return ans;
    }

    public void backtracking(int startIndex) {
        if (temp.size() > 4) {
            return;
        }
        if (temp.size() == 4 && startIndex >= s.length()) {
            StringBuilder tempBuilder = new StringBuilder();
            for (String str : temp) {
                if (tempBuilder.length() != 0) {
                    tempBuilder.append('.');
                }
                tempBuilder.append(str);
            }
            ans.add(tempBuilder.toString());
        }

        for (int i = startIndex; i < s.length(); i++) {
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
                break;
            String tempStr = s.substring(startIndex, i + 1);
            if (!check(tempStr)) {
                break;
            }
            temp.add(s.substring(startIndex, i + 1));
            backtracking(i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public boolean check(String s) {
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        String s = "101023";
        List<String> strings = restoreIpAddresses.restoreIpAddresses(s);
        System.out.println(strings);
    }
}
