package com.cyberterror.observer;

import com.cyberterror.utils.CommonUtils;

public class ThirdElement implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        CommonUtils.print_info(this.getClass().getSimpleName() + " notified: temperature " + temperature + ", humidity " + humidity + ", pressure " + pressure);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
