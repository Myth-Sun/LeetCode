package 并发编程模式;

//固定运行顺序
//必须先打印2后打印1
public class FixedOpSequence {
    static Object lock=new Object();
    static boolean t2runed = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!t2runed) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(1);
        });

        Thread t2 = new Thread(() -> {
            System.out.println(2);
            synchronized (lock) {
                t2runed = true;
                lock.notifyAll();
            }
        });
        t1.start();
        t2.start();
    }
}
