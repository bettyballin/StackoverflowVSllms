import java.lang.String;
import java.lang.List;
import android.app.Activity;
import android.content.res.Resources;
import android.widget.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.MyLocationOverlay;

public class MapActivityController extends Activity {
    private void addItemizedOverlay() {
        Resources r = getResources();
        MapView mapView = (MapView) findViewById(R.id.mymapview);
        List<Overlay> overlays = mapView.getOverlays();

        MyItemizedOverlay markers = new MyItemizedOverlay(r.getDrawable(R.drawable.icon));
        overlays.add(markers);

        // Call populate() here
        markers.populate();

        OverlayItem oi = markers.getItem(0);
        markers.setFocus(oi);
        mapView.postInvalidate();
    }

    public static void main(String[] args) {
    }
}