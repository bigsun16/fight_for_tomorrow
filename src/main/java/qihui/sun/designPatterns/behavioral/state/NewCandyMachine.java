package qihui.sun.designPatterns.behavioral.state;

import qihui.sun.designPatterns.behavioral.state.state.*;

public class NewCandyMachine {
    public final State needMoney;
    public final State haveMoney;
    public final State soldOut;
    private State state;
    private int candyCount;

    public NewCandyMachine(int candyCount) {
        this.candyCount = candyCount;
        this.needMoney = new NeedMoneyState(this);
        this.haveMoney = new HaveMoneyState(this);
        this.soldOut = new SoldOutState(this);
        if (this.candyCount > 0) {
            state = this.needMoney;
        }
    }

    public void setCandyCount(int candyCount) {
        this.candyCount = candyCount;
    }

    public int getCandyCount() {
        return candyCount;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void flipCoin() {
        state.flipCoin();
    }

    public void rejectCoin() {
        state.rejectCoin();
    }

    public void play() {
        state.play();
    }
}
