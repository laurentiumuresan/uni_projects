package isp.lab3.exercise2;

public class Rectangle {
    private int length;
    private int width;
    private String color;

    public Rectangle() {
        this.length = 1;
        this.width = 2;
        this.color = "red";
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(int length, int width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {

        return length;
    }

    public String getColor() {
        return color;
    }

    public int getPerimeter() {
        return 2 * (this.length + this.width);
    }

    public int getArea() {
        return this.length * this.width;
    }
    public static void main(String[] args) {
        Rectangle Square = new Rectangle(2, 3, "red");
        int w = Square.getWidth();
        System.out.println("The width of the square is:" + w);
        int l = Square.getLength();
        System.out.println("The length of the square is:" + l);
        String c = Square.getColor();
        System.out.println("The color of the square is:" + c);
        int A = Square.getArea();
        System.out.println("The area of the square is:" + A);
        int P = Square.getPerimeter();
        System.out.println("The perimeter of the square is:" + P);

    }

}
