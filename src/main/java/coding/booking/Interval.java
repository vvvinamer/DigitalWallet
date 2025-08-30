package coding.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
public class Interval {

    LocalTime startTime;
    LocalTime endTime;

    public boolean isIntervalGreater(int hours) {
        return Duration.between(startTime, endTime).toHours() >= hours;
    }

    public boolean doesTimeLieBetweenInterval(LocalTime time) {
        return !time.isBefore(startTime) && time.isBefore(endTime);
    }

    @Override
    public String toString() {
        return startTime.toString() + " - " + endTime.toString();
    }
}
