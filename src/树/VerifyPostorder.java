package 树;

/*
剑指 Offer 33. 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。



参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true


提示：

数组长度 <= 1000
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    //递归判断数组是否满足二叉搜索树后序遍历的条件
    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        //最后一个节点为根节点，迭代遍历找到第一个大于根节点的节点，即找到左右子树的分割点
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        //迭代遍历判断右子树的值是否都大于根节点
        while (postorder[p] > postorder[j]) {
            p++;
        }
        //递归判断左右子树是否是二叉搜索树的后序遍历
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
