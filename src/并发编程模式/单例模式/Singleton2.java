package 并发编程模式.单例模式;

//懒汉单例
public final class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 INSTANCE = null;

    public static synchronized Singleton2 getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new Singleton2();
        return INSTANCE;
    }

}
