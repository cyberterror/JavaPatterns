package com.cyberterror.observer;

import com.cyberterror.utils.CommonUtils;

public class AverageConditionDisplay implements Observer, DisplayElement {

    boolean firstMeasure = true;

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public AverageConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        if (firstMeasure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            firstMeasure = false;
        } else {
            this.temperature = (temperature + this.temperature)/2;
            this.humidity = (humidity + this.humidity)/2;
            this.pressure = (pressure + this.pressure)/2;
        }

        display();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void display() {
        CommonUtils.print_info("Average conditions: temperature " + temperature + " C, humidity " + humidity + " %, pressure " + pressure);
    }
}
