package isp.lab3.exercise3;

public class VehicleTest {

    public static void main(String[] args) {
        Vehicle Car = new Vehicle("Dacia", "Duster", 70, 'B');
        String Message=Car.toString();
        System.out.println(Message);
    }
}
