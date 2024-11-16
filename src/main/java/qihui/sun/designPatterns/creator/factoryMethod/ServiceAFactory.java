package qihui.sun.designPatterns.creator.factoryMethod;

public class ServiceAFactory implements ServiceFactory {
    @Override
    public Service createService() {
        return new ServiceA();
    }
}
