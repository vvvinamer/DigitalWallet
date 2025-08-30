package coding.booking.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RestaurantSearchRequest implements SearchRequest {

    String city;
    String area;
    String cuisine;
    String restaurantName;
    Boolean isVegetarian;
    Integer costForTwo;

}
