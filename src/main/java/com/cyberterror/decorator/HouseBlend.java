package com.cyberterror.decorator;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        this.setDescription("House Blend");
    }

    @Override
    public float cost() {
        return (float) 0.89;
    }
}
