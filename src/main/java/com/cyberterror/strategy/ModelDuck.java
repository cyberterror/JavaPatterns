package com.cyberterror.strategy;

public class ModelDuck extends Duck {
    public ModelDuck() {
        super(new FlyNoWay(), new Quack());
    }

    @Override
    void display() {

    }
}
