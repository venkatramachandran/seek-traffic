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
}