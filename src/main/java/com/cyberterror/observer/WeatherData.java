package com.cyberterror.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherData implements Subject {


    // API METHODS
    public float getTemperature() {
        float minX = 50.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    public float getHumidity() {
        float minX = 50.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    public float getPressure() {
        float minX = 50.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    // API callback
    public void measurementsChanged() {
        notifyObservers();
    }


    // OBSERVER IMPLEMENTATION
    final private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(getTemperature(), getHumidity(), getPressure());
        }
    }

    public void startWorking() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            measurementsChanged();
        }
    }
}
