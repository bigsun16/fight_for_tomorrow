package qihui.sun.designPatterns.behavioral.observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void modifyObservers();
}
