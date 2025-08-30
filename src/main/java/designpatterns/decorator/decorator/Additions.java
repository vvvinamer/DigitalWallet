package designpatterns.decorator.decorator;

import designpatterns.decorator.component.Tea;

public abstract class Additions extends Tea {

    public Additions(Tea tea, int cost, String description) {
        this.tea = tea;
        this.cost = cost;
        this.description = description;
    }

    Tea tea;
    int cost;
    String description;

    public double cost() {
        return cost + tea.cost();
    }

    public String getDescription() {
        return description + tea.getDescription();
    }
}
