package qihui.sun.designPatterns.behavioral.state.state;

import qihui.sun.designPatterns.behavioral.state.NewCandyMachine;

public class SoldOutState implements State {
    private NewCandyMachine candyMachine;
    public SoldOutState(NewCandyMachine candyMachine){
        this.candyMachine = candyMachine;
    }
    @Override
    public void flipCoin() {
        System.out.println("非常抱歉，糖果卖完了");
    }

    @Override
    public void rejectCoin() {
        System.out.println("非常抱歉，糖果卖完了");
    }

    @Override
    public void play() {
        System.out.println("非常抱歉，糖果卖完了");
    }

    @Override
    public void giveCandy() {
        System.out.println("非常抱歉，糖果卖完了");
    }
}
