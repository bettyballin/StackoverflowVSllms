import java.lang.String;

interface Shape {
    void draw();
}

class Circle_1 implements Shape {
    public void draw() {
        System.out.println("drawing circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("drawing rectangle");
    }
}

interface ShapeFactory {
    public Shape getShape(String shapeType);
}

// Factory method example of creation-via-constructors (less flexible) pattern,
// where factory does not return its own type but an implementation
public class SimpleShapeFactory implements ShapeFactory {
    public Shape getShape(String shapeType) {
        if ("circle".equalsIgnoreCase(shapeType)) {
            return new Circle_1();
        } else if ("rectangle".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        }
        // add other shapes in future as per requirement (open/closed principle)
        return null;
    }

    public static void main(String[] args) {
    }
}