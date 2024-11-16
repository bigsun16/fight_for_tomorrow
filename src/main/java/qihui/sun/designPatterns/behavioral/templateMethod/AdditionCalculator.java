package qihui.sun.designPatterns.behavioral.templateMethod;

public class AdditionCalculator extends Calculator {
    @Override
    protected void method(int numa, int numb) {
        System.out.println("两数之和结果：" + (numa + numb));
    }
}
