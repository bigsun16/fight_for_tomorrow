package qihui.sun.designPatterns.behavioral.templateMethod;

public class SubtractionCalculator extends Calculator {
    @Override
    protected void method(int numa, int numb) {
        System.out.println("两数相减结果：" + (numa - numb));
    }
}
