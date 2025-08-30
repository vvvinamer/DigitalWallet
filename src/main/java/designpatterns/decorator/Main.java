package designpatterns.decorator;

import designpatterns.decorator.component.Tea;
import designpatterns.decorator.component.impl.GreenTea;
import designpatterns.decorator.component.impl.MilkTea;
import designpatterns.decorator.decorator.impl.BadamPowder;
import designpatterns.decorator.decorator.impl.Elaichi;
import designpatterns.decorator.decorator.impl.Ginger;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Tea tea1 = new Ginger(new Elaichi(new MilkTea()));
        Tea tea2 = new Elaichi(new GreenTea());
        Tea tea3 = new BadamPowder(new Ginger(new GreenTea()));

        System.out.println(tea1.cost() + " : " + tea1.getDescription());
        System.out.println(tea2.cost() + " : " + tea2.getDescription());
        System.out.println(tea3.cost() + " : " + tea3.getDescription());
    }

}
