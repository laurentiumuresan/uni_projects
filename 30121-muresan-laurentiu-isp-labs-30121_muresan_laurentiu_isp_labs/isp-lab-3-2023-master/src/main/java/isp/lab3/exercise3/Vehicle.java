package isp.lab3.exercise3;

public class Vehicle {
    private String model;
    private String type;
    private int speed;
    private char fuelType;

    public static int nrofCars = 0;

    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        Vehicle.numberofCars();
    }

    public char getFuelType() {
        return fuelType;
    }

    public int getSpeed() {
        return speed;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    public String toString() {
        return this.model + " (" + this.type + ")" + " speed " + this.speed + " fuel type " + this.fuelType;
    }

    public static int numberofCars() {
        return nrofCars++;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        Vehicle Car1 = new Vehicle("Dacia", "Duster", 70, 'B');
        Vehicle Car2 = new Vehicle("Opel", "Astra", 90, 'D');
        String model1 = Car1.getModel();
        String type1 = Car1.getType();
        int speed1 = Car1.getSpeed();
        char fueltype1 = Car1.getFuelType();
        String model2 = Car2.getModel();
        String type2 = Car2.getType();
        int speed2 = Car2.getSpeed();
        char fueltype2 = Car2.getFuelType();
        System.out.println("The first car is a " + model1 + " " + type1 + " with the speed of " + speed1 + " and fuel type " + fueltype1);
        System.out.println("The second car is a " + model2 + " " + type2 + " with the speed of " + speed2 + " and fuel type " + fueltype2);
        boolean eq = Car1.equals(Car2);
        if (eq) {
            System.out.println("The same car ");
        } else {
            System.out.println("The cars are diferent ");
        }
    }
}
