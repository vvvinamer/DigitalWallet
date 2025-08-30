package coding.booking;

import coding.booking.impl.Restaurant;
import coding.booking.request.RestaurantSearchRequest;
import coding.booking.strategy.RestaurantSearchStrategy;
import coding.booking.strategy.RestaurantSearchStrategyFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class RestaurantsBookingManager {

    List<Restaurant> restaurants;
    RestaurantSearchStrategyFactory restaurantSearchStrategyFactory;

    public RestaurantsBookingManager() {
        this.restaurants = new ArrayList<>();
        this.restaurantSearchStrategyFactory = new RestaurantSearchStrategyFactory();
    }

     public void registerRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
         log.info("Restaurant registered: {}", restaurant.getName());
     }

     public List<Restaurant> searchRestaurant(RestaurantSearchRequest restaurantSearchRequest) {

        log.info("Searching for the restaurant with following request : {}", restaurantSearchRequest);
        RestaurantSearchStrategy restaurantSearchStrategy = restaurantSearchStrategyFactory.getRestaurantSearchStrategy(restaurantSearchRequest);
        List<Restaurant> filteredRestaurants = restaurantSearchStrategy.filterBookables(restaurants, restaurantSearchRequest);
        log.info("Following restaurants found : {} with following strategy : {}", String.join(",", filteredRestaurants.stream().map(Restaurant::getName).toList()), restaurantSearchStrategy.name());

        return filteredRestaurants;
     }

}
