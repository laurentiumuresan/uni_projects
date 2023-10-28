package aut.isp.lab4.exercise5;

public abstract class Sensor {
    private String model;
    private String manufacturer;

    @Override
    public String toString() {
        return "Sensor{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
