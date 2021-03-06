package com.cyberterror.observer;

import com.cyberterror.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherData implements Subject {

    private boolean working;

    // API METHODS
    private float getTemperature() {
        float minX = 0.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    private float getHumidity() {
        float minX = 0.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    private float getPressure() {
        float minX = 0.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    // API callback
    private void measurementsChanged() {
        notifyObservers();
    }


    // OBSERVER IMPLEMENTATION
    final private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        CommonUtils.print_good("Registered: " + observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (this.observers.indexOf(observer) >= 0) {
            CommonUtils.print_good("Removed: " + observer);
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        float temperature = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();
        for (Observer observer : this.observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void startWorking() throws InterruptedException {
        CommonUtils.print_good("Started to work");
        working = true;
        while (working) {
            measurementsChanged();
            Thread.sleep(300);
        }
    }

    public void stopWorking(){
        CommonUtils.print_good("Termination of the work");
        this.working = false;
    }
}
