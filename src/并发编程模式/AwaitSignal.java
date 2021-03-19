package 并发编程模式;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//交替输出 Lock条件变量版
public class AwaitSignal extends ReentrantLock {
    private int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void start(Condition first) {
        this.lock();
        try {
            System.out.println("start");
            first.signal();
        } finally {
            this.unlock();
        }
    }

    public void print(String str, Condition current, Condition next) {
        for (int i = 0; i < loopNumber; i++) {
            this.lock();
            try {
                current.await();
                System.out.println(str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }
        }
    }

    public static void main(String[] args) {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition aWaitSet = awaitSignal.newCondition();
        Condition bWaitSet = awaitSignal.newCondition();
        Condition cWaitSet = awaitSignal.newCondition();
        new Thread(()->{
            awaitSignal.print("a", aWaitSet, bWaitSet);
        }).start();
        new Thread(() -> {
            awaitSignal.print("b", bWaitSet, cWaitSet);
        }).start();
        new Thread(()->{
            awaitSignal.print("c",cWaitSet,aWaitSet);
        }).start();
        awaitSignal.start(aWaitSet);
    }
}
