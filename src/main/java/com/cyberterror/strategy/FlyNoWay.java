package com.cyberterror.strategy;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Doesn't fly");
    }
}
