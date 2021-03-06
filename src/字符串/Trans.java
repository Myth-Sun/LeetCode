package 字符串;
/*
字符串变形
题目描述
对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"。

输入描述:
给定一个字符串s以及它的长度n(1≤n≤500)
返回值描述:
请返回变形后的字符串。题目保证给定的字符串均由大小写字母和空格构成。
示例1
输入
"This is a sample",16
返回值
"SAMPLE A IS tHIS"
 */
public class Trans {
    public char change(char c) {
        if ('a' <= c && c <= 'z') {
            return (char) (c - 'a' + 'A');
        }
        if ('A' <= c && c <= 'Z') {
            return (char) (c - 'A' + 'a');
        }
        return c;
    }

    public String trans(String s, int n) {
        // write code here
        char[] array = s.toCharArray();
        int i = 0, j = n - 1;
        while (i <= j) {
            char iChar = change(array[i]);
            char jChar = change(array[j]);
            array[j] = iChar;
            array[i] = jChar;
            i++;
            j--;
        }
        int left = 0, right = 0;
        while (right < n) {
            while (right < n && array[right] == ' ') {
                right++;
            }
            left = right;
            while (right < n && array[right] != ' ') {
                right++;
            }
            process(array, left, right - 1);
        }
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < n; index++) {
            builder.append(array[index]);
        }
        String ans = builder.toString();
        return ans;
    }

    public void process(char[] array, int left, int right) {
        while (left <= right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
