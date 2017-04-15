package com.cyberterror.strategy;

public class DecoyDuck extends Duck {
    public DecoyDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    void display() {
        System.out.println(this.getClass().getSimpleName() + " displays");
    }
}
