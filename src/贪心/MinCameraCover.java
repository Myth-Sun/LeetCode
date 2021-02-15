package 贪心;

/*
968. 监控二叉树
给定一个二叉树，我们在树的节点上安装摄像头。

节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

计算监控树的所有节点所需的最小摄像头数量。

示例 1：

输入：[0,0,null,0,0]
输出：1
解释：如图所示，一台摄像头足以监控所有节点。
示例 2：

输入：[0,0,null,0,null,0,null,null,0]
输出：2
解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。

提示：

给定树的节点数的范围是[1, 1000]。
每个节点的值都是 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-cameras
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCameraCover {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (postTrack(root) == 0) {
            ans++;
        }
        return ans;
    }

    //后序遍历
    /*每个节点有三个状态：
        0：无覆盖
        1：有摄像头
        2：有覆盖
     */

    public int postTrack(TreeNode root) {
        if(root==null)
            return 2;
        int left = postTrack(root.left);
        int right = postTrack(root.right);

        //左右孩子为有覆盖状态，则root节点应为无覆盖状态
        if (left == 2 && right == 2) {
            return 0;
        }
        //左右孩子有一个为无覆盖状态，则root节点应安装摄像头，返回状态1
        else if (left == 0 || right == 0) {
            ans++;
            return 1;
        }
        //左右孩子有一个有摄像头，则root节点应为有覆盖状态
        else if (left == 1 || right == 1) {
            return 2;
        }

        return -1;
    }
}
