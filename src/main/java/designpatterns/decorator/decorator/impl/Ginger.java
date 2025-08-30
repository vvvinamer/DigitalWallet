package designpatterns.decorator.decorator.impl;

import designpatterns.decorator.component.Tea;
import designpatterns.decorator.decorator.Additions;

public class Ginger extends Additions {

    public Ginger(Tea tea) {
        super(tea, 5, "Ginger added -> ");
    }

}
