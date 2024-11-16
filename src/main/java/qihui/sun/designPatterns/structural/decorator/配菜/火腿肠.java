package qihui.sun.designPatterns.structural.decorator.配菜;

import qihui.sun.designPatterns.structural.decorator.煎饼;

public class 火腿肠 extends 配菜 {

    private 煎饼 bing;

    public 火腿肠(煎饼 bing) {
        this.bing = bing;
    }

    @Override
    public String getDesc() {
        return this.bing.getDesc() + ", + 火腿肠";
    }

    @Override
    public double cost() {
        return this.bing.cost() + 1.5;
    }
}
