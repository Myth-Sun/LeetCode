package 链表;

/*
92. 反转链表 II
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]


提示：

链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n


进阶： 你可以使用一趟扫描完成反转吗？
 */
public class ReverseBetween {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //新建虚拟头节点
        ListNode dumpyNode = new ListNode(-1);
        dumpyNode.next = head;
        ListNode pre = dumpyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode rightNext = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        transList(leftNode);

        pre.next = rightNode;
        leftNode.next = rightNext;
        return dumpyNode.next;
    }

    public void transList(ListNode left) {
        ListNode curNode = left, preNode = null;
        while (curNode != null) {
            ListNode temp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
        }
    }
}

