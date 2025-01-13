import java.lang.String;

// Define the Color interface
public interface Color {
  String getName();
}

// Define the Red class that implements Color
class Red implements Color {
  @Override
  public String getName() {
    return "Red";
  }
}

// Define the Shape abstract class
public abstract class Shape {
  protected Color color;

  public Shape(Color color) {
    this.color = color;
  }

  abstract public void draw();
}

// Define the Circle class that extends Shape
class Circle extends Shape {
  public Circle(Color color) {
    super(color);
  }

  @Override
  public void draw() {
    System.out.println("Drawing a " + color.getName() + " circle.");
  }
}

// Define the main class with a public static void main method
public class Main {
  public static void main(String[] args) {
    Shape circle = new Circle(new Red());
    circle.draw();
  }
}