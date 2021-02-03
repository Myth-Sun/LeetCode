package 树;

/*
701. 二叉搜索树中的插入操作
给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。

示例 1：
输入：root = [4,2,7,1,3], val = 5
输出：[4,2,7,1,3,5]
示例 2：

输入：root = [40,20,60,10,30,50,70], val = 25
输出：[40,20,60,10,30,50,70,null,null,25]
示例 3：

输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
输出：[4,2,7,1,3,5]

提示：

给定的树上的节点数介于 0 和 10^4 之间
每个节点都有一个唯一整数值，取值范围从 0 到 10^8
-10^8 <= val <= 10^8
新值和原始二叉搜索树中的任意节点值都不同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertIntoBST {
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

    //递归版本
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        insert(root, val);
        return root;
    }


    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (root.val < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }

        return root;
    }

    //迭代版本
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        TreeNode curNode = root;
        while (curNode!=null) {
            if (curNode.val < val) {
                if (curNode.right == null) {
                    TreeNode node = new TreeNode(val);
                    curNode.right = node;
                    break;
                }else{
                    curNode = curNode.right;
                }
            }else{
                if (curNode.left == null) {
                    TreeNode node = new TreeNode(val);
                    curNode.left = node;
                    break;
                }else{
                    curNode = curNode.left;
                }
            }
        }

        return root;
    }
}
