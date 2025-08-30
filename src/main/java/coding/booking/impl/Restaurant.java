package coding.booking.impl;

import coding.booking.Bookable;
import coding.booking.Cuisine;
import coding.booking.Interval;
import coding.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@Slf4j
public class Restaurant implements Bookable {

    int id;
    Map<LocalDate, Interval> availableSlots;
    String city;
    String name;
    String area;
    List<Cuisine> cuisines;
    boolean isVegetarian;
    int costForTwo;
    final int numOfDaysToLookFor = 5;
    List<RestaurantTable> tables;

    final Interval defaultWorkingHours = Interval.builder()
            .startTime(LocalTime.of(0, 0))
            .endTime(LocalTime.of(0, 0))
            .build();


    public Optional<Booking> book(int hours) {
        LocalDate currentDate = LocalDate.now();
        LocalDate maxDateToLookFor = currentDate.plusDays(numOfDaysToLookFor);

        while (!currentDate.equals(maxDateToLookFor)) {

            for (RestaurantTable table : tables) {

                Interval intervalForCurrentDate = Optional.ofNullable(availableSlots.get(currentDate))
                        .orElse(defaultWorkingHours);
                LocalTime bookingStartTime = intervalForCurrentDate.getStartTime().plusHours(0);
                LocalDateTime bookingEndDateTime = bookingStartTime.plusHours(hours).atDate(currentDate);
                LocalDateTime endTimeToLookFor = currentDate.atTime(intervalForCurrentDate.getEndTime());

                while (!bookingEndDateTime.isAfter(endTimeToLookFor)) {

                    if (table.isAvailable(currentDate, bookingStartTime, bookingEndDateTime.toLocalTime())) {
                        log.info("Found slot with following details, date : {}, slot : {}-{}", currentDate, bookingStartTime, bookingEndDateTime.toLocalTime());
                        Booking booking = Booking.builder()
                                .bookingId(UUID.randomUUID().toString())
                                .date(currentDate)
                                .interval(Interval.builder().startTime(bookingStartTime).endTime(bookingEndDateTime.toLocalTime()).build()).build();
                        table.book(booking);
                        return Optional.of(booking);
                    }

                    if (bookingEndDateTime.isAfter(endTimeToLookFor)) {
                        continue;
                    }

                    bookingStartTime = bookingStartTime.plusHours(1);
                    bookingEndDateTime = bookingEndDateTime.plusHours(1);
                }

            }

            currentDate = currentDate.plusDays(1);

        }

        log.info("Not able to find slot");
        return Optional.empty();
    }

}
