package com.cyberterror.Tests;

import com.cyberterror.observer.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherStationSimulator {
    public static void main(String[] args) throws InterruptedException {

        // Start Weather data in new thread
        Subject weatherData = new WeatherData();

        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(() -> {
            try {
                ((WeatherData)weatherData).startWorking();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // start to register elements
        Thread.sleep(1000);
        Observer currentConditionDisplay = new CurrentConditionDisplay(weatherData); // register in constructor

        // start to register elements
        Thread.sleep(3000);
        Observer averageConditionDisplay = new AverageConditionDisplay(weatherData);


        // start to register elements
        Thread.sleep(1000);


        // start to deregister elements
        Thread.sleep(5000);
        weatherData.removeObserver(currentConditionDisplay);

        // start to deregister elements
        Thread.sleep(4000);
        weatherData.removeObserver(averageConditionDisplay);


        // start to deregister elements
        Thread.sleep(1000);


        ((WeatherData)weatherData).stopWorking();
        service.shutdown();
    }
}
