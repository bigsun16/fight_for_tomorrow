package qihui.sun.designPatterns.creator.singleton;

public class Singleton {

    private Singleton() {
    }

    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return Singleton.INSTANCE;
    }
}
