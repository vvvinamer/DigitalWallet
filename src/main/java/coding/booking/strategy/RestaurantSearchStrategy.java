package coding.booking.strategy;

import coding.booking.impl.Restaurant;
import coding.booking.request.RestaurantSearchRequest;

public abstract class RestaurantSearchStrategy implements BookableSearchStrategy<Restaurant, RestaurantSearchRequest> {

    public abstract String name();

}
