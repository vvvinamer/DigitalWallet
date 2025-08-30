package designpatterns.decorator.component.impl;

import designpatterns.decorator.component.Tea;

public class GreenTea extends Tea {

    @Override
    public double cost() {
        return 15;
    }

    @Override
    public String getDescription() {
        return "Tea without Milk";
    }

}
