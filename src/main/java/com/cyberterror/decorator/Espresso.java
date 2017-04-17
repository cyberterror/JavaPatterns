package com.cyberterror.decorator;

public class Espresso extends Beverage {

    public Espresso() {
        this.setDescription("Espresso");
    }

    @Override
    public float cost() {
        return (float) 1.99;
    }
}
