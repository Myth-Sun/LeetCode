package 哈希表;

import java.util.HashMap;

/*
146. LRU 缓存机制
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。


进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？



示例：

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4


提示：

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
最多调用 3 * 104 次 get 和 put
 */
//双向链表+哈希表
public class LRUCache {
    //双向链表
    class DLinkedQueue {
        int key;
        int value;
        DLinkedQueue prev;
        DLinkedQueue next;

        public DLinkedQueue() {

        }

        public DLinkedQueue(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity;
    HashMap<Integer, DLinkedQueue> cache = new HashMap<>();
    DLinkedQueue head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //伪头部 伪尾部
        this.head = new DLinkedQueue();
        this.tail = new DLinkedQueue();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLinkedQueue node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedQueue node = cache.get(key);
        if (node == null) {
            DLinkedQueue newNode = new DLinkedQueue(key, value);
            if (size >= capacity) {
                DLinkedQueue removedNode = removeTail();
                cache.remove(removedNode.key);
                size--;
            }
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    //删除节点
    public void removeNode(DLinkedQueue node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //添加到头部
    public void addToHead(DLinkedQueue node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void moveToHead(DLinkedQueue node) {
        removeNode(node);
        addToHead(node);
    }

    public DLinkedQueue removeTail() {
        DLinkedQueue prev = tail.prev;
        removeNode(prev);
        return prev;
    }
}
