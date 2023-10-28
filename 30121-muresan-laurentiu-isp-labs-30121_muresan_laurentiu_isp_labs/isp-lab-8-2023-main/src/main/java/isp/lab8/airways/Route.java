package isp.lab8.airways;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.io.File;
import java.io.Serializable;
import java.util.*;

@Setter
@Getter
@EqualsAndHashCode
public class Route implements Serializable {
    private String name;
    private List<Waypoint> waypoints = new ArrayList<>();

    public Route(String name) {
        this.name = name;
        createFolder(this.name);
    }
    public double calculateRouteDistance() {
        double totalDistance =0;
        for (int i=1; i<waypoints.size();i++) {
            totalDistance += waypoints.get(i-1).calculateDistanceToAnotherWaypoint(waypoints.get(i));
        }
        return totalDistance;
    }

    public void createFolder(String folder) {
        File d = new File(folder);
        d.mkdirs();
    }

    public String returnFolderName(){
        File d = new File(this.name);
        d.mkdirs();
        return d.getName();
    }

}
