package lld.booking.strategy;

import lld.booking.request.RestaurantSearchRequest;
import lld.booking.strategy.impl.CityBasedRestaurantSearchStrategy;
import lld.booking.strategy.impl.CostBasedRestaurantSearchStrategy;
import lld.booking.strategy.impl.NameBasedRestaurantSearchStrategy;
import lld.booking.strategy.impl.VegetarianBasedRestaurantSearchStrategy;

import java.util.Objects;

public class RestaurantSearchStrategyFactory {

    private final RestaurantSearchStrategy cityBasedRestaurantSearchStrategy;
    private final RestaurantSearchStrategy vegetarianBasedRestaurantSearchStrategy;
    private final RestaurantSearchStrategy nameBasedRestaurantSearchStrategy;
    private final RestaurantSearchStrategy costBasedRestaurantSearchStrategy;

    public RestaurantSearchStrategyFactory() {
        this.cityBasedRestaurantSearchStrategy = new CityBasedRestaurantSearchStrategy();
        this.vegetarianBasedRestaurantSearchStrategy = new VegetarianBasedRestaurantSearchStrategy();
        this.nameBasedRestaurantSearchStrategy = new NameBasedRestaurantSearchStrategy();
        this.costBasedRestaurantSearchStrategy = new CostBasedRestaurantSearchStrategy();
    }


    public RestaurantSearchStrategy getRestaurantSearchStrategy(RestaurantSearchRequest restaurantSearchRequest) {

        if (Objects.nonNull(restaurantSearchRequest.getCity())) {
            return cityBasedRestaurantSearchStrategy;
        } else if (Objects.nonNull(restaurantSearchRequest.getRestaurantName())) {
            return nameBasedRestaurantSearchStrategy;
        } else if (Objects.nonNull(restaurantSearchRequest.getCostForTwo())) {
            return costBasedRestaurantSearchStrategy;
        }
        return vegetarianBasedRestaurantSearchStrategy;
    };

}
