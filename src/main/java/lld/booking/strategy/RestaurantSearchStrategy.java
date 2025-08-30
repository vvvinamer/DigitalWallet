package lld.booking.strategy;

import lld.booking.impl.Restaurant;
import lld.booking.request.RestaurantSearchRequest;

public abstract class RestaurantSearchStrategy implements BookableSearchStrategy<Restaurant, RestaurantSearchRequest> {

    public abstract String name();

}
