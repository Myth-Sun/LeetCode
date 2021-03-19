package 并发编程模式;

import java.util.concurrent.locks.LockSupport;

//固定运行顺序 Park&UnPark
//必须先打印2后打印1
public class FixedOpSequenceII {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println("1");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("2");
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}
