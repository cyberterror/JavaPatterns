package com.cyberterror.Tests;

import com.cyberterror.observer.*;

public class WeatherStationSimulator {
    public static void main(String[] args) throws InterruptedException {
        Subject subject = new WeatherData();
        subject.registerObserver(new FirstElement());
        subject.registerObserver(new SecondElement());
        subject.registerObserver(new ThirdElement());

        ((WeatherData)subject).startWorking();
    }
}
