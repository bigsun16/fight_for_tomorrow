package qihui.sun.designPatterns.structural;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.structural.proxy.JackieChen;
import qihui.sun.designPatterns.structural.proxy.Star;
import qihui.sun.designPatterns.structural.proxy.StarProxy;

public class ProxyTest {

    @Test
    public void test() {
        Star star = new StarProxy(new JackieChen());
        star.show(199999);
    }
}
