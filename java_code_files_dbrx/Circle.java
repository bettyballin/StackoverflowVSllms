import java.lang.String;
// Example - Separation of Concerns and Single Responsibility Principle
interface Shape {
    double getArea(); // Calculate Area
}

public class Circle implements Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius,2); // Separation of Concerns - Area calculation logic not mixed in constructor or other methods
    }

    public static void main(String[] args) {
    }
}