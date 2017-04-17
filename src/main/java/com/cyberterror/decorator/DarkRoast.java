package com.cyberterror.decorator;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        this.setDescription("Dark Roast");
    }

    @Override
    public float cost() {
        return (float) 0.99;
    }
}
