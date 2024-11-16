package qihui.sun.designPatterns.behavioral.templateMethod;

public abstract class Calculator {

    public void calcute(int numa, int numb) {
        methodA();
        method(numa, numb);
        methodB();
    }

    protected abstract void method(int numa, int numb);

    private void methodB() {
        System.out.println("methodB");
    }

    private void methodA() {
        System.out.println("methodA");
    }
}
