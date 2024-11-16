package qihui.sun.designPatterns.structural.proxy;

public class JackieChen implements Star {
    private double account;

    @Override
    public void show(double money) {
        this.account += money;
        System.out.println("成龙收到￥" + money);
        System.out.println("成龙表演功夫");
    }
}
