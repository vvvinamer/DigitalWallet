package lld.booking.strategy.impl;

import lld.booking.impl.Restaurant;
import lld.booking.request.RestaurantSearchRequest;
import lld.booking.strategy.RestaurantSearchStrategy;

import java.util.List;

public class VegetarianBasedRestaurantSearchStrategy extends RestaurantSearchStrategy {

    @Override
    public List<Restaurant> filterBookables(List<Restaurant> restaurants, RestaurantSearchRequest searchRequest) {
        return restaurants.stream().filter(restaurant -> {
            return searchRequest.getIsVegetarian().equals(restaurant.isVegetarian());
        }).toList();
    }

    @Override
    public String name() {
        return "IS VEGETARIAN BASED SEARCH";
    }
}
