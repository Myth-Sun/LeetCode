package 数组;

/*
剑指 Offer 66. 构建乘积数组
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

示例:

输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
 

提示：

所有元素乘积之和不会溢出 32 位整数
a.length <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        if (n == 0)
            return b;
        b[0] = 1;
        int temp = 1;
        //计算i之前元素的乘积
        for (int i = 1; i < n; i++) {
            temp *= a[i - 1];
            b[i] = temp;
        }
        //计算i之后元素的乘积
        temp = 1;
        for (int i = n - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        for (int num : b) {
            System.out.printf(" " + num);
        }
        return b;
    }

    public static void main(String[] args) {
        ConstructArr c = new ConstructArr();
        int[] nums = {1, 2, 3, 4, 5};
        c.constructArr(nums);
    }
}
