package 并发编程模式.单例模式;

//DCL懒汉单例
public final class SingletonDCL {
    private SingletonDCL() {

    }

    private static volatile SingletonDCL INSTANCE = null;

    public static SingletonDCL getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (SingletonDCL.class) {
            if (INSTANCE != null) {
                return INSTANCE;
            }
            INSTANCE = new SingletonDCL();
            return INSTANCE;
        }
    }
}
