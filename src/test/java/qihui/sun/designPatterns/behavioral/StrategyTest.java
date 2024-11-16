package qihui.sun.designPatterns.behavioral;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.behavioral.strategy.Calculator;

import java.util.function.BiFunction;

public class StrategyTest {
    @Test
    public void test() {
        System.out.println(new Calculator().calculate(10, 2, Integer::sum));
        System.out.println(new Calculator().calculate(10, 2, (a, b) -> a - b));
        System.out.println(new Calculator().calculate(10, 2, (a, b) -> a * b));
    }
}
