package qihui.sun.designPatterns.structural.decorator;

public class 基础煎饼 extends 煎饼{
    public 基础煎饼(){
        description = "光秃秃一个煎饼";
    }
    @Override
    public double cost() {
        return 3;
    }
}
