package com.cyberterror.Tests;

import com.cyberterror.observer_jdk.AverageConditionDisplay;
import com.cyberterror.observer_jdk.CurrentConditionDisplay;
import com.cyberterror.observer_jdk.WeatherDataJDK;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherStationSimulatorJDK {

    public static void main(String[] args) throws InterruptedException {

        // Start Weather data in new thread
        Observable weatherData = new WeatherDataJDK();

        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(() -> {
            try {
                ((WeatherDataJDK)weatherData).startWorking();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // start to register elements
        Thread.sleep(1000);
        Observer currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        // start to register elements
        Thread.sleep(3000);
        Observer averageConditionDisplay = new AverageConditionDisplay(weatherData);


        // start to register elements
        Thread.sleep(1000);


        // start to deregister elements
        Thread.sleep(5000);
        weatherData.deleteObserver(currentConditionDisplay);

        // start to deregister elements
        Thread.sleep(4000);
        weatherData.deleteObserver(averageConditionDisplay);


        // start to deregister elements
        Thread.sleep(1000);


        ((WeatherDataJDK)weatherData).stopWorking();
        service.shutdown();
    }
}
