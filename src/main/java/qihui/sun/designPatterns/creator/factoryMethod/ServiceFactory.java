package qihui.sun.designPatterns.creator.factoryMethod;

/**
 * 经与同义千问辩论感知：工厂方法模式，通常情况下工厂接口只定义一个创建单一类别产品抽象方法
 */
public interface ServiceFactory {

    Service createService();
}
