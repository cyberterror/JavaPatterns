package com.cyberterror.strategy;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Is quite");
    }
}
