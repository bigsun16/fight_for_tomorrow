package qihui.sun.designPatterns.behavioral.templateMethod;

public class DivisionCalculator extends Calculator {

    @Override
    protected void method(int numa, int numb) {
        System.out.println("两数相除结果：" + numa / numb);
    }
}
