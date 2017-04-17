package com.cyberterror.decorator;

public class Milk extends CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + this.getClass().getSimpleName();
    }

    @Override
    public float cost() {
        return (float) (beverage.cost() + .10);
    }
}
