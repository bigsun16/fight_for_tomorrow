package qihui.sun.designPatterns.creator.staticFactory;

public class StaticFactory {

    private StaticFactory() {
    }

    public static StaticService createServiceA() {
        return new StaticServiceA();
    }

    public static StaticService createServiceB() {
        return new StaticServiceB();
    }
}
