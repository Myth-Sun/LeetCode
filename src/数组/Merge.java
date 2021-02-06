package 数组;

/*
88. 合并两个有序数组
给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。

初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。


示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]


提示：

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {

    //双指针 从后往前
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mPoint = m - 1, nPoint = n - 1, point = m + n - 1;

        while (mPoint >= 0 && nPoint >= 0) {
            nums1[point--] = nums1[mPoint] > nums2[nPoint] ? nums1[mPoint--] : nums2[nPoint--];
        }
        while (nPoint >= 0) {
            nums1[point--] = nums2[nPoint--];
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        merge.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.printf(num+" ");
        }
    }
}
