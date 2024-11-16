package qihui.sun.designPatterns.behavioral.state.state;

import qihui.sun.designPatterns.behavioral.state.NewCandyMachine;

public class NeedMoneyState implements State {
    private final NewCandyMachine candyMachine;
    public NeedMoneyState(NewCandyMachine candyMachine){
        this.candyMachine = candyMachine;
    }
    @Override
    public void flipCoin() {
        candyMachine.setState(candyMachine.haveMoney);
        System.out.println("你投了一枚硬币，请摇动挡杆领取糖果");
    }

    @Override
    public void rejectCoin() {
        System.out.println("请投硬币");
    }

    @Override
    public void play() {
        System.out.println("请投硬币");
    }

    @Override
    public void giveCandy() {
        System.out.println("请投币");
    }
}
