package aut.isp.lab4.exercise6;

public abstract class Sensor {
    private String model,manufacturer;

    @Override
    public String toString() {
        return "Sensor{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
