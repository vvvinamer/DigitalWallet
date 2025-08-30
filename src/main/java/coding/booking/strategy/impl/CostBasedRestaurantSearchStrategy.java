package coding.booking.strategy.impl;

import coding.booking.impl.Restaurant;
import coding.booking.request.RestaurantSearchRequest;
import coding.booking.strategy.RestaurantSearchStrategy;

import java.util.List;

public class CostBasedRestaurantSearchStrategy extends RestaurantSearchStrategy {


    @Override
    public List<Restaurant> filterBookables(List<Restaurant> restaurants, RestaurantSearchRequest searchRequest) {

        return restaurants.stream().filter(restaurant -> {
            return restaurant.getCostForTwo() <= searchRequest.getCostForTwo();
        }).toList();

    }

    @Override
    public String name() {
        return "COST BASED SEARCH";
    }
}
