package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/*
739. 每日温度
请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用0 来代替。

例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在[30, 100]范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/daily-temperatures
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {
    //维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
    //如果需要找到左边或者右边第一个比当前位置的数大或者小，则可以考虑使用单调栈
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int num = T[i];
            while (!deque.isEmpty() && T[deque.peek()] < num) {
                Integer poll = deque.poll();
                ans[poll] = i - poll;
            }
            deque.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures.dailyTemperatures(T);
        for (int num : ints) {
            System.out.println(" " + num);
        }
    }
}
