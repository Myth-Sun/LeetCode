package 链表;

/**
 * 206.反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {
    class ListNode {
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

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode point = head;
        ListNode temp;
        while (point != null) {
            temp = point.next;
            point.next = pre;
            pre = point;
            point = temp;
        }
        return pre;
//        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode point) {
        if (point == null) {
            return pre;
        }
        ListNode temp = point.next;
        point.next = pre;
        pre = point;
        point = temp;
        return reverse(pre, point);
    }
}
