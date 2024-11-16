package qihui.sun.designPatterns.behavioral;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.behavioral.state.CandyMachineNoPattern;
import qihui.sun.designPatterns.behavioral.state.NewCandyMachine;

public class StateTest {
    @Test
    public void testNoPattern(){
        CandyMachineNoPattern candyMachine = new CandyMachineNoPattern(10);
        candyMachine.flipCoin();
        candyMachine.play();
        candyMachine.ejectCoin();
    }

    @Test
    public void testNewCandyMachine(){
        NewCandyMachine candyMachine = new NewCandyMachine(5);
        candyMachine.flipCoin();
        candyMachine.play();
        candyMachine.flipCoin();
        candyMachine.play();
        candyMachine.flipCoin();
        candyMachine.play();
        candyMachine.flipCoin();
        candyMachine.play();
        candyMachine.flipCoin();
        candyMachine.play();
        candyMachine.flipCoin();
        candyMachine.play();
    }
}
