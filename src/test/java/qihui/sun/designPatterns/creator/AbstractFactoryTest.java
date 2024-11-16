package qihui.sun.designPatterns.creator;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.creator.abstractFactory.LinuxFactory;
import qihui.sun.designPatterns.creator.abstractFactory.WindowsFactory;

public class AbstractFactoryTest {

    @Test
    public void test() {
        new WindowsFactory().createButton().buttonShow();
        new WindowsFactory().createTextBox().textBoxShow();
        new LinuxFactory().createButton().buttonShow();
        new LinuxFactory().createTextBox().textBoxShow();

    }
}
