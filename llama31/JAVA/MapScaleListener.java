// Import necessary Android classes
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

// Stub implementation of MapView and its Controller
class MapView {
    public Controller getController() {
        return new Controller();
    }
}

class Controller {
    public void zoomIn() {}
    public void zoomOut() {}
}

// Import necessary classes
import java.lang.String;

// Stub implementation of ScaleGestureDetector
class ScaleGestureDetector {
    public float getScaleFactor() {
        return 1.0f; // default value
    }

    public interface OnScaleGestureListener {
        boolean onScale(ScaleGestureDetector detector);
    }

    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            return false;
        }
    }
}

// Your original code
public class MapScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private MapView mapView;

    public MapScaleListener(MapView mapView) {
        this.mapView = mapView;
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        float scaleFactor = detector.getScaleFactor();
        if (scaleFactor > 1) {
            mapView.getController().zoomIn();
        } else if (scaleFactor < 1) {
            mapView.getController().zoomOut();
        }
        return true;
    }

    public static void main(String[] args) {
        // Create a MapView and MapScaleListener for testing
        MapView mapView = new MapView();
        MapScaleListener listener = new MapScaleListener(mapView);
        ScaleGestureDetector detector = new ScaleGestureDetector();
        listener.onScale(detector);
    }
}