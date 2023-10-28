package isp.lab6.exercise2;


import java.util.ArrayList;
import java.util.List;

public class VehicleRegistrySystem {
    private List<Vehicle> vehicles = new ArrayList();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(String VIN) {
        vehicles.remove(VIN);
    }

    public boolean checkVehicle(Vehicle vehicle) {
        for (Vehicle v : vehicles) {
            if (v.getVIN() == vehicle.getVIN()) {
                return true;
            }
        }
        return false;
    }

    public void displayVehicles(List<Vehicle> vehicles) {
        System.out.println(vehicles);
    }
}

