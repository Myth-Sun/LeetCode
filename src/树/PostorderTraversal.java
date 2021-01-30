package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PostorderTraversal {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderStack(root, ans);
        return ans;
    }

    public void postorderStack(TreeNode node, List<Integer> ans) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = node;
        TreeNode preNode = null;
        while (curNode != null || !stack.empty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            if (curNode.right == null || curNode.right == preNode) {
                ans.add(curNode.val);
                preNode = curNode;
                curNode = null;
            } else {
                stack.push(curNode);
                curNode = curNode.right;
            }
        }
    }

    public void postorder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        postorder(node.left, ans);
        postorder(node.right, ans);
        ans.add(node.val);
    }
}
