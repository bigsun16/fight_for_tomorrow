package qihui.sun.designPatterns.structural.decorator;

public abstract class 煎饼 {
    protected String description;

    public String getDesc() {
        return description;
    }

    public abstract double cost();
}
