package qihui.sun.designPatterns.creator;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.creator.factoryMethod.ServiceAFactory;
import qihui.sun.designPatterns.creator.factoryMethod.ServiceBFactory;

public class FactoryMethodTest {

    @Test
    public void test() {
        new ServiceAFactory().createService().show();
        new ServiceBFactory().createService().show();
    }
}
