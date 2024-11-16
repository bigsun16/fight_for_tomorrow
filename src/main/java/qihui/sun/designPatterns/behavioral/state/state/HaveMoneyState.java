package qihui.sun.designPatterns.behavioral.state.state;

import qihui.sun.designPatterns.behavioral.state.NewCandyMachine;

public class HaveMoneyState implements State {
    private final NewCandyMachine candyMachine;

    public HaveMoneyState(NewCandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void flipCoin() {
        System.out.println("你已经投过硬币，请勿重复投硬币");
    }

    @Override
    public void rejectCoin() {
        candyMachine.setState(candyMachine.needMoney);
        System.out.println("退还你的硬币");
    }

    @Override
    public void play() {
        giveCandy();
    }

    @Override
    public void giveCandy() {
        System.out.println("请拿好糖果");
        int candyCount = candyMachine.getCandyCount();
        if (--candyCount == 0) {

            candyMachine.setState(candyMachine.soldOut);
        } else {
            candyMachine.setState(candyMachine.needMoney);
        }
        candyMachine.setCandyCount(candyCount);
        System.out.printf("还剩%d颗糖果", candyMachine.getCandyCount());
        System.out.println();
    }
}
