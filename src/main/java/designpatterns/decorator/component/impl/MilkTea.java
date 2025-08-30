package designpatterns.decorator.component.impl;

import designpatterns.decorator.component.Tea;

public class MilkTea extends Tea {

    @Override
    public double cost() {
        return 20;
    }

    @Override
    public String getDescription() {
        return "Milk has been added";
    }

}
