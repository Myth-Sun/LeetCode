package 字符串;

import java.util.*;

/*
49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            //对字符串数组进行排序，保证字母异位词作为key的同一性
            Arrays.sort(chars);
            String keyStr = new String(chars);
            List<String> partList = map.getOrDefault(keyStr, new LinkedList<String>());
            partList.add(str);
            map.put(keyStr, partList);
        }

        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams g = new GroupAnagrams();
        List<List<String>> lists = g.groupAnagrams(strs);
        System.out.println(lists);
    }
}
