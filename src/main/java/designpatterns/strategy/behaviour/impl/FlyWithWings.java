package designpatterns.strategy.behaviour.impl;

import designpatterns.strategy.behaviour.FlyBehaviour;

public class FlyWithWings implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("Yeah I can fly!");
    }

}
