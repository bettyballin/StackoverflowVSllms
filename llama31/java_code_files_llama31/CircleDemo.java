/*
 * Decompiled with CFR 0.152.
 */
public class CircleDemo {
    public static void main(String[] stringArray) {
        Circle circle = new Circle();
        circle.setRadius(5.0);
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Diameter: " + circle.getDiameter());
        System.out.println("Circumference: " + circle.getCircumference());
    }
}
