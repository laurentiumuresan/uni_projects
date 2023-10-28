package isp.lab3.exercise4;
public class MyPoint {
    private int x;
    private int y;
    private int z;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }

    public double distance(int x, int y, int z) {
        return java.lang.Math.sqrt((this.x - x) ^ 2 + (this.y - y) ^ 2 + (this.z - z) ^ 2);
    }

    public double distance(MyPoint another) {
        return java.lang.Math.sqrt((this.x - another.x) ^ 2 + (this.y - another.y) ^ 2 + (this.z - another.z) ^ 2);
    }
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(3, 5, 7);
        MyPoint p2 = new MyPoint(5, 8, 4);
        double dist = p1.distance(p2);
        System.out.println("The distance between the two points is: " + dist);
    }
}
