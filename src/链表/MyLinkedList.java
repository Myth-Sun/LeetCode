package 链表;

/**
 * 707.设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//注意细节
public class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    int size;
    ListNode head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode point = head;
        while (index >= 0) {
            point = point.next;
            index--;
        }
        return point.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode addNode = new ListNode(val);
        addNode.next = head.next;
        head.next = addNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        int len = size;
        ListNode point = head;
        ListNode addNode = new ListNode(val);
        while (len > 0) {
            len--;
            point = point.next;
        }
        point.next = addNode;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        } else if (index < size) {
            ListNode addNode = new ListNode(val);
            ListNode point = head;
            while (index >= 0) {

                if (index == 0) {
                    addNode.next = point.next;
                    point.next = addNode;
                    size++;
                    break;
                }
                index--;
                point = point.next;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        ListNode point = head;
        while (index > 0) {
            index--;
            point = point.next;
        }
        point.next = point.next.next;
        size--;
    }

    public void printList() {
        ListNode point = head;
        while (point != null) {
            System.out.print(point.val + " ");
            point = point.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(4);
        linkedList.printList();
        int i = linkedList.get(1);
        System.out.println("get " + i);
        linkedList.addAtHead(1);
        linkedList.printList();
        linkedList.addAtHead(5);
        linkedList.printList();
        linkedList.deleteAtIndex(3);
        linkedList.printList();
        linkedList.addAtHead(7);
        linkedList.printList();

        int i1 = linkedList.get(3);
        System.out.println("get " + i1);
        linkedList.addAtHead(1);
        linkedList.printList();
        linkedList.deleteAtIndex(4);
        linkedList.printList();
    }
}
