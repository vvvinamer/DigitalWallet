package designpatterns.decorator.decorator.impl;

import designpatterns.decorator.component.Tea;
import designpatterns.decorator.decorator.Additions;

public class BadamPowder extends Additions {

    public BadamPowder(Tea tea) {
        super(tea, 30, "Badam Powder added -> ");
    }

}
