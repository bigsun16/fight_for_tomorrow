package qihui.sun.designPatterns.creator.abstractFactory;

/**
 * 与同义千问辩论后理解与工厂方法相比，抽象工厂模式是在工厂接口中定义多个创建不同类别产品的抽象方法
 */
public interface AbstractFactory {
    Button createButton();

    TextBox createTextBox();
}
