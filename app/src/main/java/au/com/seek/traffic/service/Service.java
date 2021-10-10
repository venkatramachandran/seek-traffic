package au.com.seek.traffic.service;

import java.util.List;
import au.com.seek.traffic.model.Count;

public class Service {
    private List<Count> cars;
    public Service(List<Count> cars) {
        this.cars = cars;
    }

    public int getTotalCarsSeen() {
        return this.cars.stream().mapToInt(c -> c.getVehicleCount()).sum();
    }
}