package qihui.sun.designPatterns.behavioral.state;

public class CandyMachineNoPattern {
    private static final int NEED_MONEY = 0;
    private static final int HAVE_MONEY = 1;
    private static final int SOLD_OUT = 2;
    private static final int SOLD = 3;
    private int state = SOLD_OUT;
    private int candyCount;

    public CandyMachineNoPattern(int candyCount) {
        this.candyCount = candyCount;
    }

    public void flipCoin() {
        if (state == NEED_MONEY) {
            state = HAVE_MONEY;
            System.out.println("你投了一枚硬币，请摇动挡杆领取糖果");
        } else if (state == HAVE_MONEY) {
            System.out.println("你已经投过硬币，请勿重复投硬币");
        } else if (state == SOLD_OUT) {
            System.out.println("非常抱歉，糖果卖完了，你可以操作退还硬币");
        } else if (state == SOLD) {
            System.out.println("请投硬币");
        }
    }

    public void ejectCoin() {
        if (state == NEED_MONEY) {
            System.out.println("请投硬币");
        } else if (state == HAVE_MONEY) {
            state = NEED_MONEY;
            System.out.println("退还你的硬币");
        } else if (state == SOLD_OUT) {
            System.out.println("请投硬币");
        } else if (state == SOLD) {
            System.out.println("请投硬币");
        }
    }

    public void play() {
        if (state == NEED_MONEY) {
            System.out.println("请投硬币");
        } else if (state == HAVE_MONEY) {
            state = SOLD;
            giveCandy();
        } else if (state == SOLD_OUT) {
            System.out.println("非常抱歉，糖果卖完了，你可以操作退还硬币");
        } else if (state == SOLD) {
            System.out.println("已经给过你糖果了");
        }
    }

    public void giveCandy() {
        if (state == SOLD) {
            System.out.println("请拿好糖果");
            if (--candyCount == 0) {
                state = SOLD_OUT;
            } else {
                state = NEED_MONEY;
            }
        } else if (state == NEED_MONEY) {
            state = HAVE_MONEY;
            System.out.println("请投币");
        } else if (state == HAVE_MONEY) {
            System.out.println("没有糖果了");
        } else if (state == SOLD_OUT) {
            System.out.println("没有糖果了");
        }
    }
}
