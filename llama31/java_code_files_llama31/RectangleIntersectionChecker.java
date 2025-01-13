/*
 * Decompiled with CFR 0.152.
 */
public class RectangleIntersectionChecker {
    public static void main(String[] stringArray) {
        Rectangle rectangle = new Rectangle(new Vector2D(0.0, 0.0), new Vector2D(10.0, 0.0), new Vector2D(10.0, 10.0), new Vector2D(0.0, 10.0));
        Rectangle rectangle2 = new Rectangle(new Vector2D(5.0, 5.0), new Vector2D(15.0, 5.0), new Vector2D(15.0, 15.0), new Vector2D(5.0, 15.0));
        if (rectangle.intersects(rectangle2)) {
            System.out.println("Rectangles intersect!");
        } else {
            System.out.println("Rectangles do not intersect.");
        }
    }
}
