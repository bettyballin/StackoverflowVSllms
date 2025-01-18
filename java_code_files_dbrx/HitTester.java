public class HitTester {

    // Assuming renderedCharacters is defined somewhere as a collection of CharacterFormatting objects
    private Iterable<CharacterFormatting> renderedCharacters;

    public HitTester(Iterable<CharacterFormatting> renderedCharacters) {
        this.renderedCharacters = renderedCharacters;
    }

    public boolean HitTestCharacters(Point mousePosition) {
        RectangleGeometry characterHitBox = new RectangleGeometry();
        for (CharacterFormatting info : renderedCharacters) { // your custom class holding individual character data e.g., control codes, transformations etc.
            characterHitBox.setRect(info.getBounds()); // update the geometry rectangle with current bounds of characters being tested
            if (characterHitBox.FillContains(mousePosition)) { // check if mouse position lies within hit box geometry for any rendering character
                return true; // selection identified, you can further expand this code to capture index or relevant text range info accordingly
            }
        }
        return false; // no selection found
    }

    // Other methods and fields as necessary

}

class Point {
    public double x;
    public double y;

    // Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter and setter methods if needed
}

class RectangleGeometry {

    private Rectangle rect;

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Rectangle getRect() {
        return rect;
    }

    public boolean FillContains(Point p) {
        // Implement logic to check if point p is inside rect
        if (rect == null) return false;
        return rect.contains(p);
    }
}

class Rectangle {

    private double x;
    private double y;
    private double width;
    private double height;

    // Constructor
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(Point p) {
        return (p.x >= x && p.x <= x + width && p.y >= y && p.y <= y + height);
    }

    // Getter and setter methods
}

class CharacterFormatting {
    private Rectangle bounds;

    public CharacterFormatting(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    // Other properties and methods
}