package qihui.sun.designPatterns.structural.proxy;

public class StarProxy implements Star {
    private final Star star;
    private double account;

    public StarProxy(Star star) {
        this.star = star;
    }

    @Override
    public void show(double money) {
        if (money >= 100000) {
            double payment = money * .10;
            account += payment;
            this.star.show(money - payment);
        } else {
            System.out.println("有没有搞错？？你在浪费时间。。。");
        }
    }
}
