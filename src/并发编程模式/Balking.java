package 并发编程模式;

//同步模式之Balking
//用在一个线程发现另一个线程或本线程已经做了某一件相同的事，那么本线程就无需再做，直接结束返回
public class Balking {
    private volatile boolean starting;

    public void start() {
        synchronized (this) {
            if (starting) {
                return;
            }
            starting = true;
        }
        //真正启动监控线程...
    }
}
