package qihui.sun.designPatterns.structural;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.structural.proxy.JackieChen;
import qihui.sun.designPatterns.structural.proxy.JdkProxy;
import qihui.sun.designPatterns.structural.proxy.Star;

public class JdkProxyTest {
    @Test
    public void test(){
        Star starProxy = new JdkProxy(new JackieChen()).getStarProxy();
        starProxy.show(33773);
    }

}
