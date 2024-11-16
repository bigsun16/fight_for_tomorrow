package qihui.sun.designPatterns.structural.adapter;

public class NewLogImpl implements NewLog{

    @Override
    public void newLog() {
        System.out.println("这是新的log接口");
    }
}
