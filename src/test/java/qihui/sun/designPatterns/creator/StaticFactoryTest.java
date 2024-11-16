package qihui.sun.designPatterns.creator;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.creator.staticFactory.StaticFactory;

public class StaticFactoryTest {

    @Test
    public void test() {
        StaticFactory.createServiceA().show();
        StaticFactory.createServiceB().show();
    }
}
