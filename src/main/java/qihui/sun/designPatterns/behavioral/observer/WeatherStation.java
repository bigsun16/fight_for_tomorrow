package qihui.sun.designPatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private double temperature;//温度
    private double humidity;//湿度
    private double UVIndex;//紫外线指数 (Ultraviolet Index, UV Index)
    private final List<Observer> observers;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setWeatherData(double temperature, double humidity, double UVIndex) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.UVIndex = UVIndex;
        modifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void modifyObservers() {
        observers.forEach(observer -> observer.update(temperature, humidity, UVIndex));
    }
}
