package isp.lab4.exercise3;

public class MonitoringService {
    private Sensor[] sensors = new Sensor[10];

    public double getAverageTemperatureSensor() {
        return 10*TemperatureSensor.numberOfTemperatureSensors();
    }

    public double getAveragePressureSensor() {
        return 10 * PressureSensor.numberOfPressureSensors();
    }

    public double getAverageAllSensors() {
        return 10 + (TemperatureSensor.numberOfTemperatureSensors() + PressureSensor.numberOfPressureSensors());

    }
}


