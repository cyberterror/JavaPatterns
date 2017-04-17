package com.cyberterror.decorator;

public class Soy extends CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + this.getClass().getSimpleName();
    }

    @Override
    public float cost() {
        return (float) (beverage.cost() + .15);
    }
}
