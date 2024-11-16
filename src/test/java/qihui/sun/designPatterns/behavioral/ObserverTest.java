package qihui.sun.designPatterns.behavioral;

import org.junit.jupiter.api.Test;
import qihui.sun.designPatterns.behavioral.observer.Customer;
import qihui.sun.designPatterns.behavioral.observer.Observer;
import qihui.sun.designPatterns.behavioral.observer.WeatherStation;

public class ObserverTest {
    @Test
    public void test() {
        WeatherStation weatherStation = new WeatherStation();
        new Customer(weatherStation,"Jack");
        new Customer(weatherStation,"Tom");
        new Customer(weatherStation,"Peter");
        Customer jane = new Customer(weatherStation, "Jane");
        weatherStation.setWeatherData(11.4, 22.4, 5);
        jane.cancelSubject();
        System.out.println("----------------");
        weatherStation.setWeatherData(33.4, 32.4, 15);

    }
}
