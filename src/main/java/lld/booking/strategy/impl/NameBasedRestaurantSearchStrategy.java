package lld.booking.strategy.impl;

import lld.booking.impl.Restaurant;
import lld.booking.request.RestaurantSearchRequest;
import lld.booking.strategy.RestaurantSearchStrategy;

import java.util.List;

public class NameBasedRestaurantSearchStrategy extends RestaurantSearchStrategy {


    @Override
    public List<Restaurant> filterBookables(List<Restaurant> restaurants, RestaurantSearchRequest searchRequest) {

        return restaurants.stream().filter(restaurant -> {
            return restaurant.getName().equals(searchRequest.getRestaurantName());
        }).toList();

    }

    @Override
    public String name() {
        return "NAME BASED SEARCH";
    }
}
