/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 */
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class GestureTouchListener {
    private ScaleGestureDetector scaleDetector = new ScaleGestureDetector(null, new ScaleGestureDetector.OnScaleGestureListener(this){

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    });

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.scaleDetector.onTouchEvent(motionEvent);
        return false;
    }

    public static void main(String[] stringArray) {
    }
}
