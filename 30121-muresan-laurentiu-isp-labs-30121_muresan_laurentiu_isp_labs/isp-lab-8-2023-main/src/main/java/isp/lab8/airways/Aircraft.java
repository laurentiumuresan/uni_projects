package isp.lab8.airways;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class Aircraft implements Serializable {
    private String aircraftId;
    private double averageSpeedPerHour;
    private double averageFuelConsumption;

    public Aircraft(String aircraftId, double averageSpeedPerHour, double averageFuelConsumption) {
        this.aircraftId = aircraftId;
        this.averageSpeedPerHour = averageSpeedPerHour;
        this.averageFuelConsumption = averageFuelConsumption;
    }

}
