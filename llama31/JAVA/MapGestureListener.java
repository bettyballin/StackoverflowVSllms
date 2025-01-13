import android.view.View;
import android.view.MotionEvent;
import com.google.android.gms.maps.MapView;

public class MapGestureListener implements View.OnTouchListener {
    private MapView mapView;

    public MapGestureListener(MapView mapView) {
        this.mapView = mapView;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // Add your logic here
        return false;
    }

    public static void main(String[] args) {
    }
}