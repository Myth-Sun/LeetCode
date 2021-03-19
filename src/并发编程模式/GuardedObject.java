package 并发编程模式;

//同步模式之保护性暂停
//用在一个线程等待另一个线程的执行结果
public class GuardedObject {
    private Object response;
    private Object lock;

    public Object get() {
        synchronized (lock) {
            while (response == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public void complete(Object response){
        synchronized (lock){
            this.response=response;
            lock.notifyAll();
        }
    }
}
