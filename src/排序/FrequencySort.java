package 排序;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
451. 根据字符出现频率排序
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。
 */
//hashmap+priorityQueue
public class FrequencySort {
    class Pair {
        Character c;
        Integer count;

        public Pair(Character c, Integer count) {
            this.c = c;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.count - o1.count;
            }
        });
        for (Character c : map.keySet()) {
            queue.offer(new Pair(c, map.get(c)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (queue.size() != 0) {
            Pair poll = queue.poll();
            Character c = poll.c;
            int count = poll.count;
            while (count > 0) {
                stringBuilder.append(c);
                count--;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FrequencySort f = new FrequencySort();
        String s = "cccaa";
        String s1 = f.frequencySort(s);
        System.out.println(s1);
    }

}
