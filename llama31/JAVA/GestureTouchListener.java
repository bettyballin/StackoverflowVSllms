import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class GestureTouchListener {
    private ScaleGestureDetector scaleDetector;

    public GestureTouchListener() {
        scaleDetector = new ScaleGestureDetector(null, new ScaleGestureDetector.OnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                return false;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                return true;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event) {
        scaleDetector.onTouchEvent(event);
        return false;
    }

    public static void main(String[] args) {
    }
}