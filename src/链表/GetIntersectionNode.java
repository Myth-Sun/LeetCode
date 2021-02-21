package 链表;

/*
160. 相交链表
编写一个程序，找到两个单链表相交的起始节点。
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetIntersectionNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，
     所以遍历A+B和遍历B+A一定是同时结束。
     如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点
     如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode point1 = headA, point2 = headB;
        while (point1 != point2) {
            point1 = point1 == null ? headA : point1.next;
            point2 = point2 == null ? headB : point2.next;
        }
        return point1;
    }

}
