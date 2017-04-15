package com.cyberterror.Tests;

import com.cyberterror.strategy.Duck;
import com.cyberterror.strategy.FlyRocketPowered;
import com.cyberterror.strategy.MallardDuck;
import com.cyberterror.strategy.ModelDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        System.out.println(mallardDuck);
        mallardDuck.performQuack();
        mallardDuck.performFly();

        System.out.print("\n\r");

        // ============= Example of changing behavior =============

        Duck model = new ModelDuck();
        System.out.println(model);
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
