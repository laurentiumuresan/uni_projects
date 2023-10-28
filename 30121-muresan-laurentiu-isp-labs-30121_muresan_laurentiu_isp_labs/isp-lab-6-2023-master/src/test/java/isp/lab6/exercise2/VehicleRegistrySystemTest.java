package isp.lab6.exercise2;

import org.junit.Assert;
import org.junit.Test;

public class VehicleRegistrySystemTest {

    VehicleRegistrySystem vehicleRegistrySystem = new VehicleRegistrySystem();

    @Test

    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicleRegistrySystem.addVehicle(vehicle);
        Assert.assertEquals(1, vehicleRegistrySystem.getVehicles().size());
    }

    @Test
    public void testRemoveVehicle() {
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        vehicleRegistrySystem.addVehicle(vehicle1);
        vehicleRegistrySystem.addVehicle(vehicle2);
        vehicleRegistrySystem.removeVehicle(vehicle1.getVIN());
        Assert.assertEquals(1, vehicleRegistrySystem.getVehicles().size());
    }


    @Test
    public  void testCheckVehicle(){
        Vehicle vehicle=new Vehicle("13");
        Vehicle vehicle1=new Vehicle("43");
        vehicleRegistrySystem.addVehicle(vehicle);
        Assert.assertEquals(true,vehicleRegistrySystem.checkVehicle(vehicle));
        Assert.assertEquals(false,vehicleRegistrySystem.checkVehicle(vehicle1));
    }
}
