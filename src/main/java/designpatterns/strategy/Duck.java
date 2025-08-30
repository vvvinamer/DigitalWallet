package designpatterns.strategy;

import designpatterns.strategy.behaviour.FlyBehaviour;
import designpatterns.strategy.behaviour.QuackBehaviour;
import lombok.Data;

@Data
public abstract class Duck {

    private final FlyBehaviour flyBehaviour;
    private final QuackBehaviour quackBehaviour;

    public abstract void display();

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void swim() {
        System.out.println("All ducks are able to swim!");
    }
}
