package qihui.sun.designPatterns.structural;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.structural.facade.Facade;

public class FacadeTest {
    @Test
    public void test() {
        Facade facade = new Facade();
        facade.registerCompany(100);
    }
}
