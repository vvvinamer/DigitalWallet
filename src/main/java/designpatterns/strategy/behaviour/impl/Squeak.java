package designpatterns.strategy.behaviour.impl;

import designpatterns.strategy.behaviour.QuackBehaviour;

public class Squeak implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("I don't quack but I can squeak!");
    }

}
