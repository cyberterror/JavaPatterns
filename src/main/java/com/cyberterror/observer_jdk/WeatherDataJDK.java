package com.cyberterror.observer_jdk;

import com.cyberterror.utils.CommonUtils;

import java.util.Observable;
import java.util.Random;

public class WeatherDataJDK extends Observable {

    private boolean working;
    private float temperature;
    private float humidity;
    private float pressure;

    // API METHODS
    private float testTemperature() {
        float minX = 0.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    private float testHumidity() {
        float minX = 0.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    private float testPressure() {
        float minX = 0.0f;
        float maxX = 100.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    // API callback
    private void measurementsChanged() {
        this.temperature = testTemperature();
        this.humidity = testHumidity();
        this.pressure = testPressure();
        setChanged();
        notifyObservers();
    }

    /** GETTERS */
    public boolean isWorking() {
        return working;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
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
        if (working) {
            CommonUtils.print_good("Termination of the work");
            this.working = false;
        } else {
            CommonUtils.print_error("Already stopped");
        }
    }
}
