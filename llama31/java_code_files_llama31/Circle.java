/*
 * Decompiled with CFR 0.152.
 */
class Circle {
    private double radius;

    Circle() {
    }

    public void setRadius(double d) {
        this.radius = d;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getDiameter() {
        return 2.0 * this.radius;
    }

    public double getCircumference() {
        return Math.PI * 2 * this.radius;
    }
}
