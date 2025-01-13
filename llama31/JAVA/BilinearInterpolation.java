import java.lang.String;
public class BilinearInterpolation {
    public static int interpolate(int x, int y, int width, int height) {
        // Calculate the distances from the edges
        int dx = x < width / 2 ? x : width - x;
        int dy = y < height / 2 ? y : height - y;

        // Calculate the interpolation factor
        float factor = (float) Math.min(dx, dy) / (width / 2);

        // Calculate the alpha value
        int alpha = (int) (255 * factor * factor);

        return alpha;
    }

	public static void main(String[] args) {
	}
}