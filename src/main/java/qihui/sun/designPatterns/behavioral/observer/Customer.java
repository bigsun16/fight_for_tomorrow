package qihui.sun.designPatterns.behavioral.observer;

public class Customer implements Observer {
    private String name;
    private final Subject subject;

    public Customer(Subject subject, String name) {
        this.subject = subject;
        this.name = name;
        subject.registerObserver(this);
    }

    @Override
    public void update(double temperature, double humidity, double UVIndex) {
        System.out.printf("%s 温度：%f 湿度：%f 紫外线指数：%f", name, temperature, humidity, UVIndex);
        System.out.println();
    }

    public void cancelSubject() {
        this.subject.removeObserver(this);
    }
}
