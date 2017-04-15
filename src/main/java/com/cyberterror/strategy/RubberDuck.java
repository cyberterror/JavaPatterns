package com.cyberterror.strategy;

public class RubberDuck extends Duck{
    public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    void display() {
        System.out.println(this.getClass().getSimpleName() + " displays");
    }
}
