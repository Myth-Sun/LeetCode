package 其他;

import java.util.PriorityQueue;

/*
295. 数据流的中位数
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
进阶:

如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
class MedianFinder {

    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;
    int N = 0;//

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //奇数加到左边
        if (N % 2 == 1) {
            rightMinHeap.add(num);
            leftMaxHeap.add(rightMinHeap.poll());
        } else {//偶数加到右边
            leftMaxHeap.add(num);
            rightMinHeap.add(leftMaxHeap.poll());
        }
        N++;
    }

    public double findMedian() {
        if (N % 2 == 0) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        } else {
            return (double) rightMinHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */