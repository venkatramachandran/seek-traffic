package au.com.seek.traffic.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;
import au.com.seek.traffic.model.Count;
import au.com.seek.traffic.model.Stat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.Duration;

public class Service {
    private List<Count> cars;
    public Service(List<Count> cars) {
        this.cars = cars;
    }

    public int getTotalCarsSeen() {
        return this.cars.stream().mapToInt(c -> c.getVehicleCount()).sum();
    }

    public List<Count> getTopNHours(int periods) {
        return this.cars.stream()
			.sorted(Comparator.comparingInt(Count::getVehicleCount).reversed())
            .limit(periods)
			.collect(Collectors.toList());
    }

    public List<Stat> getDailyStatistics() {
        List<Stat> retVal = new ArrayList<>();
        this.cars.stream()
            .collect(Collectors.groupingBy(c -> c.getAt().toLocalDate()))
            .forEach((k, v) -> retVal.add(new Stat(k, v.stream().mapToInt(c -> c.getVehicleCount()).sum())));
        return retVal;
    }

    public LocalDateTime getLeastTrafficHoursStart() {
        int leastCarsSeen = Integer.MAX_VALUE;
        LocalDateTime retVal = null;
        for (int i = 2; i < this.cars.size(); i++) {
            int carsSeenIn90Minutes = this.cars.get(i).getVehicleCount()+
                this.cars.get(i-1).getVehicleCount()+
                this.cars.get(i-2).getVehicleCount();
            long timeDifference = Duration.between(this.cars.get(i-2).getAt(), this.cars.get(i).getAt()).toMinutes();
            if (carsSeenIn90Minutes < leastCarsSeen && timeDifference == 60L) {
                leastCarsSeen = carsSeenIn90Minutes;
                retVal = this.cars.get(i-2).getAt();
            }
        }
        return retVal;
    }
}