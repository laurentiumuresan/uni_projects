package tests.exercise2;

import isp.lab4.exercise2.Laptop;
import isp.lab4.exercise2.SmartPhone;
import isp.lab4.exercise2.SmartWatch;

public class Exercise2Test {
    public static void main(String[] args) {
        Laptop laptop= new Laptop();
        SmartPhone phone= new SmartPhone();
        SmartWatch watch= new SmartWatch();
        laptop.charge(223);
        phone.charge(3993);
        watch.charge(0);
        laptop.charge(11111111);
        phone.charge(12);
        System.out.println(phone.getBatteryLevel());

    }
}
