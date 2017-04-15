package com.cyberterror.observer_jdk;

import com.cyberterror.utils.CommonUtils;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private final Observable observable;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void display() {
        CommonUtils.print_info("Current conditions: temperature " + temperature + " C, humidity " + humidity + " %, pressure " + pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataJDK) {
            WeatherDataJDK data  = (WeatherDataJDK) o;
            this.temperature = data.getTemperature();
            this.humidity = data.getHumidity();
            this.pressure = data.getPressure();
            display();
        }
    }
}
