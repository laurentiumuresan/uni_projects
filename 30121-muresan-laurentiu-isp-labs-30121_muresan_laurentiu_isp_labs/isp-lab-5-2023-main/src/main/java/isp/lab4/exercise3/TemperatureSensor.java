package isp.lab4.exercise3;

public class TemperatureSensor extends Sensor{
    private double temperature;
    private static int numberOfTemperatureSensor=0;

    public TemperatureSensor() {
        numberOfTemperatureSensor++;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
    public static int numberOfTemperatureSensors(){
       return numberOfTemperatureSensor;
    }
}
