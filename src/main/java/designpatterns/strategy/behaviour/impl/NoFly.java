package designpatterns.strategy.behaviour.impl;

import designpatterns.strategy.behaviour.FlyBehaviour;

public class NoFly implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }

}
