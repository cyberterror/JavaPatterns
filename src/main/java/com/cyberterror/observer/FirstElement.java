package com.cyberterror.observer;

public class FirstElement implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println(this.getClass().getSimpleName() + " notified");
    }
}
