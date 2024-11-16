package qihui.sun.designPatterns.behavioral.strategy;

import java.util.function.BiFunction;

public class Calculator {

    public int calculate(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

}
