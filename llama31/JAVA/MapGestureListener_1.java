import java.lang.String;

public class MapGestureListener_1 {
    private int fingers = 0;
    private float oldDist = 1f;

    public MapGestureListener() {
    }

    // Removed onTouch method as it uses Android-specific MotionEvent and View classes

    private float getDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static void main(String[] args) {
        MapGestureListener listener = new MapGestureListener();
        float distance = listener.getDistance(1.0f, 2.0f, 3.0f, 4.0f);
        System.out.println("Distance: " + distance);
    }
}