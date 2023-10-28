package isp.lab8.airways;

import java.io.IOException;
import java.sql.Time;
import java.util.Scanner;

public class AppInterface {
    public void loadInterface() throws IOException {
        RouteManagementApp app = new RouteManagementApp();
        app.predefinedAircraft();
        app.predefinedRoutes();
        System.out.println("Please select an action to continue:");
        System.out.println("1-Show routes.");
        System.out.println("2-Add route.");
        System.out.println("3-Remove route.");
        System.out.println("4-Show route's waypoints.");
        System.out.println("5-Add waypoint to system.");
        System.out.println("6-Add waypoint to route.");
        System.out.println("7-Remove waypoint from system.");
        System.out.println("8-Remove waypoint from route.");
        System.out.println("9-Show estimated arrival time.");
        System.out.println("10-Show estimated fly time.");
        System.out.println("11-EXIT.");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("The current routes are: ");
                app.displayRoutes();
                System.out.println("Would you like to do anything else?");
                loadInterface();
                break;
            case 2:
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Please enter the route name here: ");
                String name = scanner2.nextLine();
                app.createRoute(name);
                System.out.println("You created the route successfully.\n Now you will be directed back to the menu.");
                loadInterface();
                break;
            case 3:
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Please enter the name of the route you want to remove:");
                String nameToDelete = scanner3.nextLine();
                app.deleteRoute(nameToDelete);
                System.out.println("You removed the route successfully.\n Now you will be directed back to the menu.");
                loadInterface();

                break;
            case 4:
                Scanner scanner4 = new Scanner(System.in);
                System.out.println("Please enter the name of the route you want to show waypoints:");
                String nameToShow = scanner4.nextLine();
                System.out.println("The waypoints for the selected route:");
                app.displayWaypointsFromRoute(nameToShow);
                loadInterface();
                break;
            case 5:
                Scanner scanner5 = new Scanner(System.in);
                Scanner scanner51 = new Scanner(System.in);
                System.out.println("Please add the waypoint's information below:");
                System.out.println("Waypoint index");
                int index = scanner5.nextInt();
                System.out.println("Waypoint name");
                String waypointName = scanner51.nextLine();
                System.out.println("Waypoint latitude");
                double latitude = scanner5.nextDouble();
                System.out.println("Waypoint longitude");
                double longitude = scanner5.nextDouble();
                System.out.println("Waypoint altitude");
                int altitude = scanner5.nextInt();
                app.createWaypoint(index, waypointName, latitude, longitude, altitude);
                System.out.println("You created the waypoint.\n Now you will be directed back to the menu.");
                loadInterface();
                break;
            case 6:
                Scanner scanner6 = new Scanner(System.in);
                System.out.println("Please add the waypoint's information below:");
                System.out.println("Waypoint index");
                int index1 = scanner6.nextInt();
                System.out.println("Waypoint name");
                String waypointName1 = scanner6.nextLine();
                System.out.println("Waypoint latitude");
                double latitude1 = scanner6.nextDouble();
                System.out.println("Waypoint longitude");
                double longitude1 = scanner6.nextDouble();
                System.out.println("Waypoint altitude");
                int altitude1 = scanner6.nextInt();
                System.out.println("Please add the route name:");
                String routeName = scanner6.nextLine();
                app.addWaypointToRoute(index1, waypointName1, latitude1, longitude1, altitude1, routeName);
                System.out.println("You added the waypoint successfully to route " + routeName + ".\n Now you will be directed back to the menu.");
                loadInterface();
                break;
            case 7:
                Scanner scanner7 = new Scanner(System.in);
                System.out.println("Please enter the name of the waypoint that you want to delete: ");
                String waypointToDelete = scanner7.nextLine();
                app.deleteWaypoint(waypointToDelete);
                System.out.println("You deleted the waypoint successfully from the system.\n Now you will be directed back to the menu.");
                loadInterface();
                break;
            case 8:
                Scanner scanner8 = new Scanner(System.in);
                System.out.println("Please enter the name of the route: ");
                String route = scanner8.nextLine();
                System.out.println("Please enter the name of the waypoint that you want to delete: ");
                String waypointToDelete1 = scanner8.nextLine();
                app.deleteWaypointFromRoute(waypointToDelete1, route);
                System.out.println("You deleted the waypoint successfully from route " + route + ".\n Now you will be directed back to the menu.");
                loadInterface();
                break;
            case 9:
                Scanner scanner9 = new Scanner(System.in);
                System.out.println("Please enter the plane id: ");
                String id = scanner9.nextLine();
                System.out.println("Please enter the route's name: ");
                String routeToCalculate = scanner9.nextLine();
                System.out.println("Please select a departure time: ");
                System.out.println("Hour:");
                int hour = scanner9.nextInt();
                System.out.println("Minutes:");
                int minutes = scanner.nextInt();
                Time time = new Time(hour, minutes, 0);
                System.out.println("Estimated arrival time for the selected aircraft and route is " + app.calculateEstimatedArrivalTime(time, app.getAircraft(id), app.getRoute(routeToCalculate)));
                loadInterface();
                break;
            case 10:
                Scanner scanner10 = new Scanner(System.in);
                System.out.println("Please enter the plane id: ");
                String id1 = scanner10.nextLine();
                System.out.println("Please enter the route's name: ");
                String routeToCalculate1 = scanner10.nextLine();
                System.out.println("The estimated fly time for the selected aircraft and route is " + app.calculateEstimatedFlyTime(app.getAircraft(id1), app.getRoute(routeToCalculate1)));
                loadInterface();
                break;
            case 11:
                System.out.println("See ya!");
                break;
            default:
                System.out.println("Please select a valid option!");
                loadInterface();
                break;
        }


    }
}
