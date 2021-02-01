package 树;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出:
 * 1
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * 输出:
 * 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindBottomLeftValue {
    class TreeNode {
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

    int maxDepth = Integer.MIN_VALUE;
    int ans = Integer.MIN_VALUE;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > maxDepth) {
            ans = root.val;
            maxDepth = depth;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
