package qihui.sun.designPatterns.behavioral.templateMethod;

public class MultiplicationCalculator extends Calculator {
    @Override
    protected void method(int numa, int numb) {
        System.out.println("两数相乘结果：" + numa * numb);
    }
}
