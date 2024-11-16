package qihui.sun.designPatterns.structural.facade;

public class Facade {
    private double money;
    private AIC aic;
    private Bank bank;
    private STA sta;

    public Facade() {
        this.aic = new AIC();
        this.bank = new Bank();
        this.sta = new STA();
    }

    public void registerCompany(double money) {
        this.money += money;
        System.out.println("钱已收到，开始办事。。。。");
        aic.createLicense();
        bank.createCount();
        sta.applyAccount();
        System.out.println("over");
    }
}
