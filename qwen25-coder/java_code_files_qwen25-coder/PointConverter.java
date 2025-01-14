public class PointConverter implements Converter<Point> {
    @Override
    public Point read(InputNode node) throws Exception {
        int x = Integer.parseInt(node.getAttribute("x").getValue());
        int y = Integer.parseInt(node.getAttribute("y").getValue());
        return new Point(x, y);
    }

    @Override
    public void write(OutputNode node, Point point) throws Exception {
        OutputNode child = node.addChild("point");
        child.setAttribute("x", String.valueOf(point.getX()));
        child.setAttribute("y", String.valueOf(point.getY()));
    }

    public static void main(String[] args) {
        // You can add test code here
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x; 
        this.y = y;
    }

    public int getX() { 
        return x; 
    }
    public int getY() { 
        return y; 
    }
}

interface Converter<T> {
    T read(InputNode node) throws Exception;
    void write(OutputNode node, T value) throws Exception;
}

class InputNode {
    public Attribute getAttribute(String name) {
        return new Attribute("0"); // Stub implementation
    }
}

class OutputNode {
    public OutputNode addChild(String name) {
        return new OutputNode();
    }
    public void setAttribute(String name, String value) {
        // Stub implementation
    }
}

class Attribute {
    private String value;
    public Attribute(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}