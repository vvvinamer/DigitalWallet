package coding.booking.strategy.impl;

import coding.booking.impl.Restaurant;
import coding.booking.request.RestaurantSearchRequest;
import coding.booking.strategy.RestaurantSearchStrategy;

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
