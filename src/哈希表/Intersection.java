package 哈希表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] nums = new int[1];

        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        for (int num : nums1)
            nums1Set.add(num);
        for (int num : nums2)
            nums2Set.add(num);

        return findIntersection(nums1Set, nums2Set);
    }

    public int[] findIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return findIntersection(set2, set1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num))
                list.add(num);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] intersection1 = intersection.intersection(nums1, nums2);
        for(int num:intersection1)
            System.out.print(num+" ");
    }
}
