package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
17. 电话号码的字母组合

给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]


提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class LetterCombinations {
    List<String> ans = new ArrayList<>();
    Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    StringBuilder temp = new StringBuilder();
    String digits;

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return ans;
        }
        this.digits = digits;
        backtracking(0);
        return ans;
    }

    public void backtracking(int index) {
        if (index == digits.length()) {
            ans.add(temp.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            temp.append(letter);
            backtracking(index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        String digits = "2";
        List<String> strings = letterCombinations.letterCombinations(digits);
        System.out.println(strings);
    }
}
