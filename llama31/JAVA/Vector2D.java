import java.lang.String;
public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(x - other.x, y - other.y);
    }

    public Vector2D normal() {
        return new Vector2D(-y, x);
    }

    public double dot(Vector2D other) {
        return x * other.x + y * other.y;
    }

	public static void main(String[] args) {
	}
}