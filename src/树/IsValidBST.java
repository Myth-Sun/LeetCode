package 树;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {
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

    int preNumber = -Integer.MAX_VALUE - 1000000;

    public boolean isValidBST(TreeNode root) {
        return preorder(root, null, null);
    }

    //中序遍历：中序遍历二叉搜索树得到的是一个递增的序列，通过判断序列是否递增得到改树是否为二叉搜索树
    public boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = inorder(root.left);
        if (!left)
            return false;
        if (root.val <= preNumber) {
            return false;
        }
        preNumber = root.val;
        boolean right = inorder(root.right);
        return right;
    }

    //前序遍历 中左右
    public boolean preorder(TreeNode root, TreeNode low, TreeNode high) {
        if (root == null) {
            return true;
        }
        if (low != null && root.val <= low.val) {
            return false;
        }
        if (high != null && root.val >= high.val) {
            return false;
        }
        if (!preorder(root.left, low, root))
            return false;
        if (!preorder(root.right, root, high))
            return false;
        return true;
    }

}
