package qihui.sun.designPatterns.creator;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.creator.singleton.Singleton;
import qihui.sun.designPatterns.creator.singleton.SingletonLazy;
import qihui.sun.designPatterns.creator.singleton.SingletonStaticInner;

import java.util.stream.IntStream;

class SingletonTest {

    @Test
    public void testHungry() {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }

    @Test
    public void testLazy() {
        IntStream.range(0, 100).parallel().forEach((item) -> System.out.println(SingletonLazy.getInstance() + "-->" + Thread.currentThread().getName()));
    }

    @Test
    public void testStaticInnerClass() {
        IntStream.range(0, 100).parallel().forEach((item) ->
                System.out.println(SingletonStaticInner.getInstance() + "-->" + Thread.currentThread().getName()));
    }
}