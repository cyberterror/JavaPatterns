package com.cyberterror.strategy;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying like a rocket");
    }
}
