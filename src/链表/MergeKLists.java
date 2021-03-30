package 链表;

/*
23. 合并K个升序链表
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。



示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]


提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
 */
public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode node : lists) {
            ans = mergeTwoLists(ans, node);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode dumpyNode = new ListNode();
        ListNode curNode = dumpyNode, aIndex = a, bIndex = b;
        while (aIndex != null && bIndex != null) {
            if (aIndex.val < bIndex.val) {
                curNode.next = aIndex;
                aIndex = aIndex.next;
            } else {
                curNode.next = bIndex;
                bIndex = bIndex.next;
            }
            curNode = curNode.next;
        }
        curNode.next = aIndex == null ? bIndex : aIndex;
        return dumpyNode.next;
    }
}
