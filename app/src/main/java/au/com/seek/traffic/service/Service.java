package au.com.seek.traffic.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import au.com.seek.traffic.model.Count;

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
}