package com.cyberterror.strategy;

public class MallardDuck extends Duck{
    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    void display() {
        System.out.println(this.getClass().getSimpleName() + " displays");
    }
}
