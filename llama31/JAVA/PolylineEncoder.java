import java.lang.String;
public class PolylineEncoder {
    private static final String ENCODE_TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    public static String encode(int[] points) {
        StringBuilder encodedPoints = new StringBuilder();
        int prevPoint = 0;
        for (int point : points) {
            int delta = point - prevPoint;
            prevPoint = point;

            int shift = 0;
            while ((delta >> shift) > 0) {
                encodedPoints.append(ENCODE_TABLE.charAt(((delta >> shift) & 0x1F) + ((shift > 0) ? 0x20 : 0)));
                shift += 5;
            }
        }
        return encodedPoints.toString();
    }

    public static int[] decode(String encodedPoints) {
        int[] points = new int[encodedPoints.length()];
        int prevPoint = 0;
        int pointIndex = 0;

        for (int i = 0; i < encodedPoints.length(); i++) {
            int shift = 0;
            int delta = 0;

            while (shift < 25) {
                char c = encodedPoints.charAt(i++);
                int value = ENCODE_TABLE.indexOf(c);
                if (value < 0) {
                    throw new RuntimeException("Invalid character in encoded polyline: " + c);
                }
                delta |= ((value & 0x1F) << shift);
                shift += 5;
                if (value < 0x20) {
                    break;
                }
            }

            prevPoint += (delta & 1) != 0 ? ~(delta >> 1) : delta >> 1;
            points[pointIndex++] = prevPoint;
        }

        return points;
    }

	public static void main(String[] args) {
	}
}