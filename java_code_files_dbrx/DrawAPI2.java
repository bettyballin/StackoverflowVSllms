interface DrawApi {
    void drawShape(int x, int y, int radius);
}

class DrawAPI2 implements DrawApi {
    @Override
    public void drawShape(int x, int y, int radius) {
        System.out.println("Drawing shape with DrawAPI2 at (" + x + ", " + y + ") with radius " + radius);
    }
}

abstract class Shape {
    protected DrawApi drawApi;

    protected Shape(DrawApi drawApi){
        this.drawApi = drawApi;
    }
    public abstract void draw();
}

class Square extends Shape {
    private int x, y, radius;

    public Square(DrawApi drawApi){
        super(drawApi);
        this.x = 1;
        this.y = 1;
        this.radius = 10;
    }

    @Override
    public void draw() {
        System.out.println("Square is being drawn");
        drawApi.drawShape(x, y, radius);
    }
}

public class Main {
    public static void main(String[] args) {
        DrawApi drawApi1 = new DrawAPI2(); // low-level module
        Shape shape1 = new Square(drawApi1); // high-level module
        shape1.draw(); // calls the respective draw methods in both high-level & low-level classes
    }
}