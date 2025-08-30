package designpatterns.strategy.impl;

import designpatterns.strategy.Duck;
import designpatterns.strategy.behaviour.impl.FlyWithWings;
import designpatterns.strategy.behaviour.impl.Quack;


public class MallardDuck extends Duck {


    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("Yo, I am a real duck!");
    }

}
