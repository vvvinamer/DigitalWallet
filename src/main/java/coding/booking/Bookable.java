package coding.booking;

import java.util.Optional;

public interface Bookable {

    Optional<Booking> book(int hours);


}
