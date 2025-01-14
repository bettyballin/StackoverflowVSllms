public class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        this.radius = 0.0;
    }

    // Constructor with radius parameter
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter for radius
    public double getRadius() {
        return this.radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Method to calculate diameter
    public double getDiameter() {
        return 2 * this.radius;
    }

    // Method to calculate circumference
    public double getCircumference() {
        return 2 * Math.PI * this.radius;
    }

    // Method to calculate area
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}