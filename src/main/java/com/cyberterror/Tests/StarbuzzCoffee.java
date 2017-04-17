package com.cyberterror.Tests;

import com.cyberterror.decorator.*;

public class StarbuzzCoffee {

    public static void main(String[] args) {

        // Espresso without any condiment
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // Mocha with tree condiments
        Beverage beverage1 = new Whip(new Mocha(new Mocha(new DarkRoast())));
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
    }
}






