package qihui.sun.designPatterns.structural.decorator;

public class 鸡蛋煎饼 extends 煎饼{
    public 鸡蛋煎饼(){
        description = "鸡蛋煎饼";
    }
    @Override
    public double cost() {
        return 4;
    }
}
