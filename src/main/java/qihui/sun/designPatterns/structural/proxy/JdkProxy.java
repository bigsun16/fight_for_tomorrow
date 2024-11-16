package qihui.sun.designPatterns.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {
    private final Star target;

    public JdkProxy(Star star) {
        this.target = star;
    }

    public Star getStarProxy() {
        return (Star) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), JackieChen.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("show".equals(method.getName()) && Double.parseDouble(String.valueOf(args[0])) > 10000) {
                    return method.invoke(target, args);
                } else {
                    System.out.println("钱不够");
                    return null;
                }

            }
        });
    }
}
