package 并发编程模式.单例模式;

//静态内部类懒汉单例
public final class Singleton3 {
    private Singleton3() {
    }

    private static class LazyLoader {
        static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return LazyLoader.INSTANCE;
    }
}
