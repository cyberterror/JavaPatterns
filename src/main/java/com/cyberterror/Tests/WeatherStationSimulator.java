package com.cyberterror.Tests;

import com.cyberterror.observer.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherStationSimulator {
    public static void main(String[] args) throws InterruptedException {

        // Start Weather data in new thread
        Subject subject = new WeatherData();

        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(() -> {
            try {
                ((WeatherData)subject).startWorking();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // start to register elements
        Thread.sleep(1000);
        Observer observer1 = new FirstElement();
        subject.registerObserver(observer1);

        // start to register elements
        Thread.sleep(3000);
        Observer observer2 = new SecondElement();
        subject.registerObserver(observer2);

        // start to register elements
        Thread.sleep(1000);
        Observer observer3 = new ThirdElement();
        subject.registerObserver(observer3);

        // start to deregister elements
        Thread.sleep(2000);
        subject.removeObserver(observer1);

        // start to deregister elements
        Thread.sleep(4000);
        subject.removeObserver(observer2);

        // start to deregister elements
        Thread.sleep(1000);
        subject.removeObserver(observer3);

        ((WeatherData)subject).stopWorking();
        service.shutdown();
    }
}
