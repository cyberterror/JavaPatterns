package com.cyberterror.strategy;

public class RedheadDuck extends Duck{
    public RedheadDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    void display() {
        System.out.println(this.getClass().getSimpleName() + " displays");
    }
}
