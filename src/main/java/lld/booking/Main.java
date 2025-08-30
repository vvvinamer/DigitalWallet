package lld.booking;

import lld.booking.impl.Restaurant;
import lld.booking.impl.RestaurantTable;
import lld.booking.request.RestaurantSearchRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        RestaurantsBookingManager restaurantsBookingManager = new RestaurantsBookingManager();

        //registering restaurants.
        Restaurant meghnaFoods = Restaurant.builder()
                .name("Meghna Foods")
                .costForTwo(400)
                .city("Bangalore")
                .availableSlots(Map.of(LocalDate.now(), Interval.builder()
                                .startTime(LocalTime.of(18, 0))
                                .endTime(LocalTime.of(23, 0))
                        .build()))
                .cuisines(List.of(Cuisine.NORTH_INDIAN))
                .tables(List.of(new RestaurantTable()))
                .build();
        restaurantsBookingManager.registerRestaurant(meghnaFoods);

        Restaurant kailashParbat = Restaurant.builder()
                .name("Kailash Parbat")
                .costForTwo(600)
                .city("Bangalore")
                .build();
        restaurantsBookingManager.registerRestaurant(kailashParbat);

        Restaurant monuKulchaHut = Restaurant.builder()
                .name("Monu Kulcha Hut")
                .costForTwo(150)
                .city("Amritsar")
                .build();
        restaurantsBookingManager.registerRestaurant(monuKulchaHut);

        //searching restaurants
        List<Restaurant> restaurants = restaurantsBookingManager.searchRestaurant(RestaurantSearchRequest.builder()
                        .restaurantName("Meghna Foods").build());
        restaurants.get(0).book(1);
        restaurants.get(0).book(2);
        restaurants.get(0).book(3);

        restaurantsBookingManager.searchRestaurant(RestaurantSearchRequest.builder()
                .costForTwo(599).build());


        System.out.println(UUID.randomUUID());
    }

}
