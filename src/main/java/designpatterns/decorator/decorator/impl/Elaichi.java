package designpatterns.decorator.decorator.impl;

import designpatterns.decorator.component.Tea;
import designpatterns.decorator.decorator.Additions;

public class Elaichi extends Additions {

    public Elaichi(Tea tea) {
        super(tea, 20, "Elaichi added -> ");
    }

}
