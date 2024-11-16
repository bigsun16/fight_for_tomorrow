package qihui.sun.designPatterns.creator.singleton;

/**
 * 静态内部类实现的单例模式利用了 JVM 的类加载机制来确保线程安全，同时实现了延迟加载。
 * 当 Singleton 类第一次被加载时，Holder 类不会被加载。
 * 只有当 getInstance 方法被调用时，Holder 类才会被加载，并且 INSTANCE 会被初始化。
 * 由于类加载是原子操作，JVM 保证了即使是多线程环境下，Holder 类也只会被加载一次，因此只会有一个 Singleton 实例被创建
 */
public class SingletonStaticInner {

    private SingletonStaticInner() {
    }

    public static SingletonStaticInner getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final SingletonStaticInner INSTANCE = new SingletonStaticInner();
    }
}
