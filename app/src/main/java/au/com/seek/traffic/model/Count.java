package au.com.seek.traffic.model;
import java.time.LocalDateTime;
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
}