package 树;

/**
 * 112. 路径总和
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasPathSum {
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

    int target;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        target = targetSum;
        return dfs(root, 0);
    }

    public boolean dfs(TreeNode root, int sum) {
        sum = sum + root.val;
        if (root.left == null && root.right == null && sum == target) {
            return true;
        }
        if (root.left != null) {
            if (dfs(root.left, sum)) {
                return true;
            }
        }
        if (root.right != null) {
            if (dfs(root.right, sum)) {
                return true;
            }
        }
        return false;
    }

}
