import java.lang.String;

// Define the Circle class
class Circle {
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}

public class CircleDemo {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(5.0);
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Diameter: " + circle.getDiameter());
        System.out.println("Circumference: " + circle.getCircumference());
    }
}