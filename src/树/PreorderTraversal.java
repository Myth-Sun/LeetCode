package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOderStack(root, ans);
        return ans;
    }

    public void preOderStack(TreeNode node, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            TreeNode mid = stack.pop();
            if (mid != null) {
                ans.add(mid.val);
            } else {
                continue;
            }
            stack.push(mid.right);
            stack.push(mid.left);
        }
    }

    //递归解法
    public void preOrder(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;
        ans.add(node.val);
        preOrder(node.left, ans);
        preOrder(node.right, ans);
    }
}
