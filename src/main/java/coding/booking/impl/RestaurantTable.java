package coding.booking.impl;

import coding.booking.Booking;
import coding.booking.Interval;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class RestaurantTable {
    int id;
    int capacity;
    List<Booking> bookings;

    public RestaurantTable() {
        this.bookings = new ArrayList<>();
    }

    public boolean isAvailable(LocalDate date, LocalTime startTime, LocalTime endTime) {

        for (Booking booking : bookings) {
            if (date.equals(booking.getDate())
                    && (booking.getInterval().doesTimeLieBetweenInterval(startTime)
                    || booking.getInterval().doesTimeLieBetweenInterval(endTime)) ) {
                return false;
            }
        }
        return true;
    }

    public void book(Booking booking) {
        this.bookings.add(booking);
    }
}
