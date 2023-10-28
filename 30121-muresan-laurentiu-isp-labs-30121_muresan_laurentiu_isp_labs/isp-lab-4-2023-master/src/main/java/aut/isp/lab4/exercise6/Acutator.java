package aut.isp.lab4.exercise6;

public abstract class Acutator {
    private String manufacturer,model;
    public void turnOn(){}
    public void turnOff(){}


    public String toString() {
        return "Acutator{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}


