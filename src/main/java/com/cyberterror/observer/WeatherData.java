package com.cyberterror.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {


    // API METHODS
    public float getTemperature() {
        return 0;
    }

    public float getHumidity() {
        return 0;
    }

    public float getPressure() {
        return 0;
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
}
