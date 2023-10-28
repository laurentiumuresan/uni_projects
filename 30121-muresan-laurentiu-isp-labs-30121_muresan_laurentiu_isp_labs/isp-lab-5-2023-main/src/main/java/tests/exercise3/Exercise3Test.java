package tests.exercise3;

import isp.lab4.exercise3.MonitoringService;
import isp.lab4.exercise3.PressureSensor;
import isp.lab4.exercise3.TemperatureSensor;

public class Exercise3Test {
    public static void main(String[] args) {
        PressureSensor ps1 = new PressureSensor();
        PressureSensor ps2 = new PressureSensor();
        PressureSensor ps3 = new PressureSensor();
        TemperatureSensor ts1 = new TemperatureSensor();
        TemperatureSensor ts2 = new TemperatureSensor();
        MonitoringService ms = new MonitoringService();
        ms.getAveragePressureSensor();
        ms.getAverageAllSensors();
        System.out.println("The average of temperature sensors is " + ms.getAverageTemperatureSensor() + "% of the total number of sensors!");
        System.out.println("The average of pressure sensors is " + ms.getAveragePressureSensor() + "% of the total number of sensors!");
    }
}
