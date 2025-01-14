import java.lang.String;
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

abstract class ShapeFactory {
    // Use getShape method to get object of type shape.
    abstract Shape getShape(String shapeType);
}

class ShapeFactoryImpl extends ShapeFactory {
    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactoryImpl();

        // Get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        // Call draw method of Circle
        shape1.draw();

        // Get an object of Square and call its draw method.
        Shape shape2 = shapeFactory.getShape("SQUARE");

        // Call draw method of circle
        shape2.draw();
    }
}