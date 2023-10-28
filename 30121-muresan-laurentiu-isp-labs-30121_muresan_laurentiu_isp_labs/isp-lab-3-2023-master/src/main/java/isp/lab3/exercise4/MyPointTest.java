package isp.lab3.exercise4;
import java.lang.Math;
public class MyPointTest {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(3, 5, 7);
        MyPoint p2 = new MyPoint(5, 8, 4);
        double dist = p1.distance(p2);
        System.out.println("The distance between the two points is: " + dist);
    }
}
