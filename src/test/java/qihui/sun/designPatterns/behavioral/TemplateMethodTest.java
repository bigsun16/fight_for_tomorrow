package qihui.sun.designPatterns.behavioral;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.behavioral.templateMethod.*;

public class TemplateMethodTest {

    @Test
    public void test(){
        Calculator calculator = new AdditionCalculator();
        calculator.calcute(2,5);
        Calculator subtractionCalculator = new SubtractionCalculator();
        System.out.println("------------");
        subtractionCalculator.calcute(2,5);
        Calculator multiplicationCalculator = new MultiplicationCalculator();
        System.out.println("------------");
        multiplicationCalculator.calcute(2,5);
        Calculator divisionCalculator = new DivisionCalculator();
        System.out.println("------------");
        divisionCalculator.calcute(2,5);
    }
}
