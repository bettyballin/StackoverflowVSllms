/*
 * Decompiled with CFR 0.152.
 */
class Rectangle {
    private Vector2D topLeft;
    private Vector2D topRight;
    private Vector2D bottomRight;
    private Vector2D bottomLeft;

    public Rectangle(Vector2D vector2D, Vector2D vector2D2, Vector2D vector2D3, Vector2D vector2D4) {
        this.topLeft = vector2D;
        this.topRight = vector2D2;
        this.bottomRight = vector2D3;
        this.bottomLeft = vector2D4;
    }

    public boolean intersects(Rectangle rectangle) {
        return this.topLeft.getX() < rectangle.topRight.getX() && this.topRight.getX() > rectangle.topLeft.getX() && this.topLeft.getY() < rectangle.bottomLeft.getY() && this.bottomLeft.getY() > rectangle.topLeft.getY();
    }
}
