import java.lang.String;
public class RectangleAreaCalculator {
    public int calculateArea(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height must be non-negative");
        }
        return width * height;
    }

	public static void main(String[] args) {
	}
}