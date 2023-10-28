package isp.lab6.exercise2;

public class Vehicle {
    private String VIN;
    private String licensePlate;
    private String make;
    private String model;
    private int year;

    public Vehicle() {
    }

    public Vehicle(String VIN, String licensePlate, String make, String model, int year) {
        this.VIN = VIN;
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Vehicle(String VIN) {
        this.VIN = VIN;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getYear() {
        return year;
    }

    public String getVIN() {
        return VIN;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VIN='" + VIN + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
