package qihui.sun.designPatterns.structural;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.structural.decorator.基础煎饼;
import qihui.sun.designPatterns.structural.decorator.煎饼;
import qihui.sun.designPatterns.structural.decorator.配菜.火腿肠;
import qihui.sun.designPatterns.structural.decorator.配菜.辣条;
import qihui.sun.designPatterns.structural.decorator.配菜.鸡蛋;

public class 煎饼test {

    @Test
    public void test(){
        煎饼 base = new 基础煎饼();
        煎饼 煎饼 = new 火腿肠(base);
        煎饼 = new 辣条(煎饼);
        煎饼 = new 鸡蛋(煎饼);
        System.out.println(煎饼.cost());
        System.out.println(煎饼.getDesc());
    }
}
