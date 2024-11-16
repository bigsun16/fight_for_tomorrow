package qihui.sun.designPatterns.behavioral.observer;

public interface Observer {
    void update(double Temperature,double Humidity,double UVIndex);
    void cancelSubject();
}
