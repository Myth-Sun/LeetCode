package 并发编程模式.单例模式;

import java.io.Serializable;

//饿汉单例
public final class SingletonI implements Serializable {
    private SingletonI(){}

    private static final SingletonI INSTANCE = new SingletonI();

    public static SingletonI getInstance() {
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
