package qihui.sun.designPatterns.structural.decorator.配菜;

import qihui.sun.designPatterns.structural.decorator.煎饼;

public class 土豆丝 extends 配菜 {

    private 煎饼 bing;

    public 土豆丝(煎饼 bing) {
        this.bing = bing;
    }

    @Override
    public String getDesc() {
        return this.bing.getDesc() + ", + 一份土豆丝";
    }

    @Override
    public double cost() {
        return this.bing.cost() + .5;
    }
}
