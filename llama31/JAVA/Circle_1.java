import java.lang.String;

public class Circle_1_1 {
    private double radius; // declare the radius variable

    public Circle_1(double radius) { // add a constructor to initialize the radius
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        Circle_1 circle = new Circle_1(5.0); // create an instance of Circle_1
        System.out.println("Area: " + circle.getArea());
        System.out.println("Circumference: " + circle.getCircumference());
    }
}