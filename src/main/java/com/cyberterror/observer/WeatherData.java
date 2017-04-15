package com.cyberterror.observer;

import com.cyberterror.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherData implements Subject {

    private boolean working;

    // API METHODS
    private float getTemperature() {
        float minX = 50.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    private float getHumidity() {
        float minX = 50.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    private float getPressure() {
        float minX = 50.0f;
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
        CommonUtils.print_good("Removed: " + observer);
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(getTemperature(), getHumidity(), getPressure());
        }
    }

    public void startWorking() throws InterruptedException {
        CommonUtils.print_good("Started to work");
        working = true;
        while (working) {
            measurementsChanged();
            Thread.sleep(1000);
        }
    }

    public void stopWorking(){
        CommonUtils.print_good("Termination of the work");
        this.working = false;
    }
}
