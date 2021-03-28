package 字符串;

import java.util.LinkedList;
import java.util.Queue;

/*
字符流中第一个不重复的字符
题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
返回值描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class DuplicateCharacter {
    //Insert one char from stringstream
    int[] array = new int[128];
    Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        array[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && array[queue.peek()] > 1) {
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
