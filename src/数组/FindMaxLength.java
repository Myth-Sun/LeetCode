package 数组;

import java.util.HashMap;

/*
525. 连续数组
给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。



示例 1:

输入: nums = [0,1]
输出: 2
说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
示例 2:

输入: nums = [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。


提示：

1 <= nums.length <= 105
nums[i] 不是 0 就是 1
 */
public class FindMaxLength {
    //前缀和 + 哈希表
    public int findMaxLength(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                ans = Math.max(ans, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }
        return ans;
    }
}
