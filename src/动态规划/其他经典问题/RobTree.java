package 动态规划.其他经典问题;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RobTree {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        //抢劫root节点
        int steal = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : (rob(root.right.left) + rob(root.right.right)));
        //不抢劫root节点,然后去下家
        int notSteal = rob(root.left) + rob(root.right);
        int res = Math.max(steal, notSteal);
        memo.put(root, res);
        return res;
    }
}
