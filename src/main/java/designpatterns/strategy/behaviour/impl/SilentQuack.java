package designpatterns.strategy.behaviour.impl;

import designpatterns.strategy.behaviour.QuackBehaviour;

public class SilentQuack implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("Silent Quack");
    }

}
