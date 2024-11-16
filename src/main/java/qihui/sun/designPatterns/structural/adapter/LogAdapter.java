package qihui.sun.designPatterns.structural.adapter;

public class LogAdapter implements OldLog {

    private final NewLog log;

    public LogAdapter(NewLog log) {
        this.log = log;
    }

    @Override
    public void log() {
        this.log.newLog();
    }
}
