package com.cyberterror.strategy;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Is quacking");
    }
}
