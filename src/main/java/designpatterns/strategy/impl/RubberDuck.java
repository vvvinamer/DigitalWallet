package designpatterns.strategy.impl;

import designpatterns.strategy.Duck;
import designpatterns.strategy.behaviour.impl.NoFly;
import designpatterns.strategy.behaviour.impl.Squeak;

public class RubberDuck extends Duck {

    public RubberDuck() {
        super(new NoFly(), new Squeak());
    }

    @Override
    public void display() {
        System.out.println("Yo, I am a rubber duck!");
    }

}
