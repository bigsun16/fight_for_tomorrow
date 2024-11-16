package qihui.sun.designPatterns.structural.decorator.配菜;

import qihui.sun.designPatterns.structural.decorator.煎饼;

public class 鸡蛋 extends 配菜 {

    private 煎饼 bing;

    public 鸡蛋(煎饼 bing) {
        this.bing = bing;
    }

    @Override
    public String getDesc() {
        return this.bing.getDesc() + ", + 一个鸡蛋";
    }

    @Override
    public double cost() {
        return this.bing.cost() + 1;
    }
}
