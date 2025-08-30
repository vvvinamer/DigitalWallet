package lld.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Booking {
    Interval interval;
    LocalDate date;
    String bookingId;
}
