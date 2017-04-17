package com.cyberterror.decorator;

public class Decaf extends Beverage {

    public Decaf() {
        this.setDescription("Decaf");
    }

    @Override
    public float cost() {
        return (float) 1.05;
    }
}
