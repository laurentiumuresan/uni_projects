package isp.lab4.exercise3;

public class PressureSensor extends Sensor {
    private double pressure;
    private static int numberOfPressureSensor = 0;

    public PressureSensor() {
        numberOfPressureSensor++;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getPressure() {
        return pressure;
    }

    public static int numberOfPressureSensors() {
        return numberOfPressureSensor;
    }
}
