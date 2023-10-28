package isp.lab8.airways;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Time;

import static org.junit.Assert.*;

public class AirwaysTest {
    RouteManagementApp app = new RouteManagementApp();

    @Test

    public void createRouteTest() {
        app.createRoute("name");
        Assert.assertEquals(1, app.getRoutes().size());
    }

    @Test

    public void deleteRouteTest() {
        app.createRoute("name1");
        app.createRoute("name2");
        app.deleteRoute("name1");
        Assert.assertEquals(1, app.getRoutes().size());
    }

    @Test

    public void getRouteTest() {
        app.createRoute("name");
        Route route = new Route("name");
        Assert.assertEquals(route, app.getRoute("name"));
    }

    @Test
    public void getWaypointTest() {
        try {
            app.createWaypoint(1, "name", 1, 1, 1);
            Waypoint wp = new Waypoint(1, "name", 1, 1, 1);
            Waypoint waypoint = new Waypoint("name");
            Assert.assertEquals(wp, app.getWaypoint("name"));
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }
    }

    @Test

    public void addWaypointToRouteTest() {
        app.createRoute("name");
        try {
            app.addWaypointToRoute(1, "name", 1, 1, 1, "name");
            app.addWaypointToRoute(12, "name1", 11, 11, 21, "name");
            Assert.assertEquals(2, app.getRoute("name").getWaypoints().size());
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }
    }

    @Test

    public void deleteWaypointFromRouteTest() {
        app.createRoute("name");
        try {
            app.addWaypointToRoute(1, "name1", 1, 1, 1, "name");
            app.addWaypointToRoute(2, "name2", 11, 21, 14, "name");
            Assert.assertEquals(2, app.getRoute("name").getWaypoints().size());
            app.deleteWaypointFromRoute("name1", "name");
            Assert.assertEquals(1, app.getRoute("name").getWaypoints().size());
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }
    }

    @Test

    public void createWaypointTest() {
        try {
            app.createWaypoint(1, "name", 1, 1, 1);
            Assert.assertEquals(1, app.getWaypoints().size());
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }

    }


    @Test

    public void deleteWaypoint() {
        try {
            app.createWaypoint(1, "name", 1, 1, 1);
            app.createWaypoint(1, "name1", 1, 1, 1);
            app.deleteWaypoint("name");
            Assert.assertEquals(1, app.getWaypoints().size());
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }

    }

    @Test

    public void calculateRouteDistance() {
        app.createRoute("SFO-LAS");
        try {
            app.addWaypointToRoute(1, "PYE", 37.552250, -122.318167, 558, "SFO-LAS");
            app.addWaypointToRoute(2, "LKV", 41.313444, -120.775361, 930, "SFO-LAS");
            app.addWaypointToRoute(3, "TQQ", 36.448861, -116.888306, 1300, "SFO-LAS");
            Assert.assertEquals(1075.542796924146, app.getRoute("SFO-LAS").calculateRouteDistance(),1);
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }
    }

    @Test

    public void calculateEstimatedFlyTimeTest() {
        Aircraft aircraft = new Aircraft("12", 800, 20);
        app.createRoute("SFO-LAS");
        Time time = new Time(1, 20, 0);
        try {
            app.addWaypointToRoute(1, "PYE", 37.552250, -122.318167, 558, "SFO-LAS");
            app.addWaypointToRoute(2, "LKV", 41.313444, -120.775361, 930, "SFO-LAS");
            app.addWaypointToRoute(3, "TQQ", 36.448861, -116.888306, 1300, "SFO-LAS");
            Assert.assertEquals(time, app.calculateEstimatedFlyTime(aircraft, app.getRoute("SFO-LAS")));
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }
    }

    @Test

    public void calculateEstimatedArrivalTimeTest() {
        Aircraft aircraft = new Aircraft("12", 800, 20);
        app.createRoute("SFO-LAS");
        Time time = new Time(1, 20, 0);
        Time arrivalTime = new Time(13, 20, 0);
        Time departureTime = new Time(12, 0, 0);
        try {
            app.addWaypointToRoute(1, "PYE", 37.552250, -122.318167, 558, "SFO-LAS");
            app.addWaypointToRoute(2, "LKV", 41.313444, -120.775361, 930, "SFO-LAS");
            app.addWaypointToRoute(3, "TQQ", 36.448861, -116.888306, 1300, "SFO-LAS");
            Assert.assertEquals(arrivalTime, app.calculateEstimatedArrivalTime(departureTime, aircraft, app.getRoute("SFO-LAS")));
        } catch (IOException ioException) {
            ioException.fillInStackTrace();
        }
    }
}