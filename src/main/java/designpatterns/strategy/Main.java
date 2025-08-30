package designpatterns.strategy;

import designpatterns.strategy.impl.MallardDuck;
import designpatterns.strategy.impl.RubberDuck;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Duck> ducks = List.of(new RubberDuck(), new MallardDuck());
        for (Duck duck : ducks) {
            duck.display();
            duck.swim();
            duck.performFly();
            duck.performQuack();
            System.out.println();
        }
    }

}
