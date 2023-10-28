package isp.lab8.airways;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class RouteManagementApp implements Serializable {
    private Set<Route> routes = new HashSet<>();
    private List<Waypoint> waypoints = new ArrayList<>();
    private Set<Aircraft> aircraftSet = new HashSet<>();

    public void createRoute(String name) {
        Route route = new Route(name);
        routes.add(route);
    }

    public Route getRoute(String name) {
        for (Route route : routes) {
            if (route.getName().equals(name)) {
                return route;
            }
        }
        return null;
    }
    public Waypoint getWaypoint(String name) {
        Waypoint waypoint=new Waypoint(0,name,0,0,0);
        for (Waypoint value : waypoints) {
            if (waypoint.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public Aircraft getAircraft(String id) {
        for (Aircraft aircraft : aircraftSet) {
            if (aircraft.getAircraftId().equals(id)) {
                return aircraft;
            }
        }
        return null;
    }


    public void addWaypointToRoute(int index, String name, double latitude, double longitude, int altitude, String routeName) throws IOException {
        Waypoint waypoint = new Waypoint(index, name, latitude, longitude, altitude);
        try {
            createWaypoint(index, name, latitude, longitude, altitude);
            writeWaypoint(waypoint, routeName + "\\" + name + ".txt");
            this.waypoints.add(waypoint);
            getRoute(routeName).getWaypoints().add(waypoint);
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }
    }

    public void createWaypoint(int index, String name, double latitude, double longitude, int altitude) throws IOException {
        Waypoint waypoint = new Waypoint(index, name, latitude, longitude, altitude);
        try {
            this.waypoints.add(waypoint);
            createFolder("Waypoints");
            writeWaypoint(waypoint, "Waypoints\\" + name + ".txt");
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }
    }

    public void deleteWaypoint(String name) {
       waypoints.remove(getWaypoint(name));
        File file = new File("Waypoints\\"+ name + ".txt");
        file.deleteOnExit();
        file.delete();
    }

    public void deleteWaypointFromRoute(String name, String routeName) {
        getRoute(routeName).getWaypoints().remove(getWaypoint(name));
        File file = new File(routeName + "\\" + name + ".txt");
        file.deleteOnExit();
        file.delete();
    }

    public void deleteRoute(String name) {
        routes.remove(getRoute(name));
        File d = new File(name);
        for (File file : d.listFiles()) {
            file.delete();
        }
        d.delete();
    }

    public void writeWaypoint(Waypoint waypoint, String destinationFile) throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(destinationFile)))) {
            os.writeObject(waypoint);
            os.flush();
        }
    }

    public void writeAircraft(Aircraft aircraft, String destinationFile) throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(destinationFile)))) {
            os.writeObject(aircraft);
            os.flush();
        }
    }

//    public List<String> getWaypoints(Route route) {
//        File file = null;
//        String[] paths;
//        file = new File(route.getName());
//        return Arrays.asList(file.list());
//    }

    public void displayWaypointsFromRoute(String routeName){
        for(Waypoint waypoint: getRoute(routeName).getWaypoints()){
            System.out.println(waypoint.getName());
        }
    }

    public void displayRoutes() {
        for (Route route : routes) {
            System.out.println(route.getName());
        }
    }

    public double calculateAverageFuelConsumption(Aircraft aircraft, Route route) {
        return aircraft.getAverageFuelConsumption() * route.calculateRouteDistance();
    }

    public Time calculateEstimatedFlyTime(Aircraft aircraft, Route route) {
        Time time=new Time(1,1,1);
        time.setHours((int) (route.calculateRouteDistance() / aircraft.getAverageSpeedPerHour()));
        time.setMinutes((int) ((route.calculateRouteDistance() / aircraft.getAverageSpeedPerHour()-time.getHours())*60));
        time.setSeconds(0);
        return time;
    }

    public Time calculateEstimatedArrivalTime(Time departureTime, Aircraft aircraft, Route route) {
        Time flyTime = calculateEstimatedFlyTime(aircraft, route);
        Time arrivalTime = new Time(0, 0, 0);
        arrivalTime.setSeconds((flyTime.getSeconds() + departureTime.getSeconds()) % 60);
        arrivalTime.setMinutes((flyTime.getMinutes() + departureTime.getMinutes() + (flyTime.getSeconds() + departureTime.getSeconds()) / 60) % 60);
        arrivalTime.setHours(flyTime.getHours() + departureTime.getHours() + (flyTime.getMinutes() + departureTime.getMinutes()) / 60);
        return arrivalTime;
    }

    public void createFolder(String folder) {
        File d = new File(folder);
        d.mkdirs();
    }

    public void predefinedRoutes() throws IOException {
        //Cluj-Napoca to Bucharest
        createRoute("LRCL-LROP");
        addWaypointToRoute(1, "LRCL", 46.7852, 23.6862, 415, "LRCL-LROP");
        addWaypointToRoute(2, "TASOD", 47.0548, 23.9212, 10460, "LRCL-LROP");
        addWaypointToRoute(3, "SOPAV", 46.9804, 24.7365, 10900, "LRCL-LROP");
        addWaypointToRoute(4, "BIRGU", 45.9467, 26.0217, 10200, "LRCL-LROP");
        addWaypointToRoute(5, "LROP", 44.5711, 26.0858, 106, "LRCL-LROP");
        //San Francisco to Las Vegas
        createRoute("SFO-LAS");
        addWaypointToRoute(1, "PYE", 37.552250, -122.318167, 558, "SFO-LAS");
        addWaypointToRoute(2, "LKV", 41.313444, -120.775361, 930, "SFO-LAS");
        addWaypointToRoute(3, "TQQ", 36.448861, -116.888306, 1300, "SFO-LAS");
        //New York to Miami
        createRoute("JFK-MIA");
        addWaypointToRoute(1, "CCC", 41.423389, -71.012389, 930, "JFK-MIA");
        addWaypointToRoute(2, "SBY", 38.340525, -75.510425, 930, "JFK-MIA");
        addWaypointToRoute(3, "EMI", 34.988056, -79.015500, 930, "JFK-MIA");
        addWaypointToRoute(4, "HILEY", 33.586528, -81.694472, 930, "JFK-MIA");
        addWaypointToRoute(5, "GISSH", 32.612194, -82.566861, 930, "JFK-MIA");
        addWaypointToRoute(6, "PERMT", 28.644694, -81.402861, 930, "JFK-MIA");
        //Chicago to Seattle
        createRoute("ORD-SEA");
        addWaypointToRoute(1, "ROD", 41.582694, -87.493083, 930, "ORD-SEA");
        addWaypointToRoute(2, "BAE", 42.453972, -90.318972, 930, "ORD-SEA");
        addWaypointToRoute(3, "FSD", 43.583389, -96.728222, 930, "ORD-SEA");
        addWaypointToRoute(4, "ONL", 42.470306, -100.381306, 930, "ORD-SEA");
        addWaypointToRoute(5, "MLD", 46.841389, -120.110389, 930, "ORD-SEA");
        //Londo to Dubai
        createRoute("LHR-DXB");
        addWaypointToRoute(1, "DVR", 51.551472, -0.441667, 463, "LHR-DXB");
        addWaypointToRoute(2, "MALUD", 51.080444, 1.491556, 463, "LHR-DXB");
        addWaypointToRoute(3, "SUPUR", 50.600139, 3.012139, 463, "LHR-DXB");
        addWaypointToRoute(4, "DIMAL", 50.233333, 4.433333, 463, "LHR-DXB");
        addWaypointToRoute(5, "PIKOK", 49.125, 5.418889, 463, "LHR-DXB");
    }

    public void predefinedAircraft() throws IOException {
        createFolder("Aircraft");
        Aircraft aircraft1 = new Aircraft("1", 400, 23);
        aircraftSet.add(aircraft1);
        Aircraft aircraft2 = new Aircraft("2", 400, 23);
        aircraftSet.add(aircraft2);
        Aircraft aircraft3 = new Aircraft("3", 400, 23);
        aircraftSet.add(aircraft3);
        Aircraft aircraft4 = new Aircraft("4", 400, 23);
        aircraftSet.add(aircraft4);
        Aircraft aircraft5 = new Aircraft("5", 400, 23);
        aircraftSet.add(aircraft5);
        Aircraft aircraft6 = new Aircraft("6", 400, 23);
        aircraftSet.add(aircraft6);
        for (Aircraft aircraft : aircraftSet) {
            try {
                writeAircraft(aircraft, "Aircraft\\" + aircraft.getAircraftId() + ".txt");
            } catch (IOException ioException) {
                ioException.fillInStackTrace();
            }
        }
    }
}
