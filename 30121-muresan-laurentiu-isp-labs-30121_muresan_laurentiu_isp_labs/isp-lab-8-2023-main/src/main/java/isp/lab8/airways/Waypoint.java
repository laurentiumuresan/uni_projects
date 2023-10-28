package isp.lab8.airways;

import examples.serializableObject.Vehicle;
import lombok.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Example waypoint class which can be extended to be used in implementation of the exercise. Add constructor, getters, setters, etc.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Waypoint implements Serializable {
    private int index;
    private String name;
    private double latitude;
    private double longitude;
    private int altitude;

    public Waypoint(String name) {
        this.name = name;
    }

    public void writeWaypoint(Waypoint waypoint, String destinationFile) throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(destinationFile)))) {
            os.writeObject(waypoint);
            os.flush();
        }
    }

    public Waypoint readWaypoint(String sourceFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(sourceFile)))) {
            return (Waypoint) in.readObject();
        }
    }

    public double calculateDistanceToAnotherWaypoint(Waypoint waypoint) {
        if (waypoint == null) {
            return 0.0;
        } else {
            int earthRadius = 6371; // Radius of the Earth in kilometers
            double dLat = Math.toRadians(waypoint.latitude - this.latitude);
            double dLon = Math.toRadians(waypoint.longitude - this.longitude);
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                    Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(waypoint.latitude)) *
                            Math.sin(dLon / 2) * Math.sin(dLon / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = earthRadius * c;
            return distance;
        }
    }
}
