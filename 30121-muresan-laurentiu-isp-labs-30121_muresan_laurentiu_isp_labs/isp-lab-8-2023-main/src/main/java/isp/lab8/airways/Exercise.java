package isp.lab8.airways;

import java.io.IOException;
import java.sql.Time;
public class Exercise {
    public static void main(String[] args) throws IOException {
        AppInterface appInterface=new AppInterface();
        appInterface.loadInterface();
     //   RouteManagementApp app = new RouteManagementApp();
//        app.predefinedRoutes();
//        app.predefinedAircraft();
//        app.createWaypoint(1, "ROP", 44.5711, 26.0858, 106);
//        System.out.println(app.getRoute("LRCL-LROP").calculateRouteDistance());
//        System.out.println(app.getRoute("LRCL-LROP").calculateRouteDistance());
//        System.out.println(app.getRoute("LRCL-LROP").toString());
//        System.out.println(app.getWaypoints(app.getRoute("LRCL-LROP")));
//       app.displayRoutes();
//        Aircraft aircraft = new Aircraft();
//        aircraft.setAverageSpeedPerHour(734);
//        Waypoint waypoint1 =new Waypoint(1, "LL", 46.7852, 23.6862, 415);
//        Waypoint waypoint2 =new Waypoint(1, "LRL", 46.732852, 22.62, 100);
//        System.out.println(waypoint2.calculateDistanceToAnotherWaypoint(waypoint1));
//       System.out.println( app.calculateEstimatedFlyTime(aircraft,app.getRoute("SFO-LAS")));
//       System.out.println( app.calculateEstimatedArrivalTime(new Time(12,30,0),aircraft,app.getRoute("SFO-LAS")));
//       app.deleteRoute("LRCL-LROP");
    }
}
