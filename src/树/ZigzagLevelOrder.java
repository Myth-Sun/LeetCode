package 树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
103. 二叉树的锯齿形层序遍历
给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 */
public class ZigzagLevelOrder {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReverse = true;
        while (queue.size() != 0) {
            int size = queue.size();
            Deque<Integer> levelList = new LinkedList<>();//使用双端队列
            for (int i = 0; i < size; i++) {
                TreeNode pollNode = queue.poll();
                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
                if (isReverse) {
                    levelList.addLast(pollNode.val);
                } else {
                    levelList.addFirst(pollNode.val);
                }
            }
            resList.add(new LinkedList<>(levelList));
            isReverse = !isReverse;
        }
        return resList;
    }
}
