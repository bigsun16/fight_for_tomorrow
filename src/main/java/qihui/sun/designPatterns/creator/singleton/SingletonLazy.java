package qihui.sun.designPatterns.creator.singleton;

import java.util.concurrent.TimeUnit;

public class SingletonLazy {
    private SingletonLazy() {
    }

    private static volatile SingletonLazy INSTANCE;

    public static SingletonLazy getInstance() {
        if (SingletonLazy.INSTANCE == null) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (SingletonLazy.class) {
                if (SingletonLazy.INSTANCE == null) {
                    SingletonLazy.INSTANCE = new SingletonLazy();
                }
            }
        }
        return SingletonLazy.INSTANCE;
    }
}
