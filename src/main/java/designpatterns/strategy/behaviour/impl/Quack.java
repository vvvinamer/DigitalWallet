package designpatterns.strategy.behaviour.impl;

import designpatterns.strategy.behaviour.QuackBehaviour;

public class Quack implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("Yeah I can quack!");
    }

}
