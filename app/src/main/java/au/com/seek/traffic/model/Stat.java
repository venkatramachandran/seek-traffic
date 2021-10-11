package au.com.seek.traffic.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Stat {
    private LocalDate at;
    private int vehicleCount;

    public Stat(LocalDate at, int vehicleCount) {
        this.at = at;
        this.vehicleCount = vehicleCount;
    }

    public int getVehicleCount() {
        return this.vehicleCount;
    }

    public LocalDate getAt() {
        return this.at;
    }

    public String toString() {
        return this.at.format(DateTimeFormatter.ISO_LOCAL_DATE)+ " "+this.vehicleCount;
    }
}