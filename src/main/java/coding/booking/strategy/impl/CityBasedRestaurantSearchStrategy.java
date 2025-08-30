package coding.booking.strategy.impl;

import coding.booking.impl.Restaurant;
import coding.booking.request.RestaurantSearchRequest;
import coding.booking.strategy.RestaurantSearchStrategy;

import java.util.List;

public class CityBasedRestaurantSearchStrategy extends RestaurantSearchStrategy {


    @Override
    public List<Restaurant> filterBookables(List<Restaurant> restaurants,  RestaurantSearchRequest searchRequest) {

        return restaurants.stream().filter(restaurant -> {
            return restaurant.getCity().equals(searchRequest.getCity());
        }).toList();

    }


    @Override
    public String name() {
        return "CITY BASED SEARCH";
    }
}
