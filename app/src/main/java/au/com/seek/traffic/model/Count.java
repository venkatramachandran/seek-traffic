package au.com.seek.traffic.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Count {
    private LocalDateTime at;
    private int vehicleCount;

    public Count(LocalDateTime at, int vehicleCount) {
        this.at = at;
        this.vehicleCount = vehicleCount;
    }

    public int getVehicleCount() {
        return this.vehicleCount;
    }

    public LocalDateTime getAt() {
        return this.at;
    }

    public String toString() {
        return this.at.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+ " "+this.vehicleCount;
    }
}