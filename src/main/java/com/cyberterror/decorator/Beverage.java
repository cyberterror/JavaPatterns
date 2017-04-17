package com.cyberterror.decorator;

public abstract class Beverage {
    private String description;

    public Beverage() {
        this.description = "Unknown Beverage";
    }

    void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract float cost();
}
