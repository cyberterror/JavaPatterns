package com.cyberterror.observer_jdk;

import com.cyberterror.utils.CommonUtils;

import java.util.Observable;
import java.util.Observer;

public class AverageConditionDisplay implements DisplayElement, Observer {


    boolean firstMeasure = true;

    private float temperature;
    private float humidity;
    private float pressure;

    private final Observable observable;


    public AverageConditionDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);

    }

    @Override
    public void display() {
        CommonUtils.print_info("Average conditions: temperature " + temperature + " C, humidity " + humidity + " %, pressure " + pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataJDK) {
            WeatherDataJDK data = (WeatherDataJDK) o;

            if (firstMeasure) {
                this.temperature = data.getTemperature();
                this.humidity = data.getHumidity();
                this.pressure = data.getPressure();
                firstMeasure = false;
            } else {
                this.temperature = (data.getTemperature() + this.temperature)/2;
                this.humidity = (data.getHumidity() + this.humidity)/2;
                this.pressure = (data.getPressure() + this.pressure)/2;
            }
            display();
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
