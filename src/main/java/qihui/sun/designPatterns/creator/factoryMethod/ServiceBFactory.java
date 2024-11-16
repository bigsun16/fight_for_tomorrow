package qihui.sun.designPatterns.creator.factoryMethod;

public class ServiceBFactory implements ServiceFactory {
    @Override
    public Service createService() {
        return new ServiceB();
    }
}
