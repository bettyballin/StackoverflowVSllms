import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends MapActivity {
    private List<Overlay> mapOverlays;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // This gets a reference to the MapView from your layout XML file.
        // You should replace "myMap" with its actual id (e.g., R.id.mymap)
        MapView mapView = findViewById(R.id.my_map_view_xml_id);
        // This gets a reference to the object responsible for managing overlays (such as our List of Overlays):
        mapOverlays = mapView.getOverlays();

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.icon); // get a suitable icon/marker image from resources.
        MyItemizedOverlay itemizedoverlay = new MyItemizedOverlay(drawable, this);

        GeoPoint point1, point2;
        OverlayItem overlayitem1, overlayitem2;

        List<GeoPoint> points = new ArrayList<>(); // A list to store our coordinates for the route (if you want a routing map)
        // But in your case, it will be just any random coordinate, not necessarily forming any route.
        LatLng point1Latlng = new LatLng(37.584602, -122.349309); // Your first GeoPoint (latitude & longitude).
        // It should be replaced with your lat and lng value.
        point1 = new GeoPoint((int) (point1Latlng.getLat() * 1E6), (int) (point1Latlng.getLon() * 1E6));

        overlayitem1 = new OverlayItem(point1, "Overlay title", "Overlay description"); // This creates a single item as part of our customized item overlay list.
        points.add(point1); // Add this GeoPoint to route's path (in your case, it can be multiple points added and displayed, but they are not any specific route - just random coordinates).
        OverlayItem[] list = new OverlayItem[points.size()]; // A fixed size overlay-item array is created for each GeoPoint in our List "points".
        int i = 0;
        for (GeoPoint p : points) { // We'll start adding individual Overlays for Point (p).
            list[i++] = new OverlayItem(p, "", ""); // Here you will add your data in form of string array or whatever suits. I am leaving it blank ("") as an example right now.
        }
        itemizedoverlay.setPointToDraw(list); // This line adds the Points (GeoPoints) to our custom overlay for drawing:
        mapOverlays.add(itemizedoverlay); // And finally, add this new overlays list with multiple points to your MapView!
    }

    @Override // You must provide implementation of protected Override onTap() method.
    protected boolean onTap(int index) {
        OverlayItem item = null; // This is needed because it's a required Overriding method, but it doesn't seem like you need the "On Tap" functionality right now to make points appear.
        return true; // Change this depending on whether tapping an overlaid area should have any effect (true for yes, false for no)
    }

    public static void main(String[] args) {
    }
}

// Necessary stub classes to make the code compile

class MapActivity {
    public void onCreate(Bundle savedInstanceState) {
    }

    public void setContentView(int layoutResID) {
    }

    public <T> T findViewById(int id) {
        return null;
    }

    public Resources getResources() {
        return new Resources();
    }
}

class MapView {
    public List<Overlay> getOverlays() {
        return new ArrayList<>();
    }
}

class Bundle {
}

class R {
    static class layout {
        static int main = 1;
    }

    static class drawable {
        static int icon = 1;
    }

    static class id {
        static int my_map_view_xml_id = 1;
    }
}

class Resources {
    public Drawable getDrawable(int id) {
        return new Drawable();
    }
}

class Drawable {
}

class MyItemizedOverlay extends ItemizedOverlay {
    public MyItemizedOverlay(Drawable drawable, MapActivity activity) {
    }

    public void setPointToDraw(OverlayItem[] list) {
    }
}

class ItemizedOverlay {
    protected boolean onTap(int index) {
        return false;
    }
}

class GeoPoint {
    public GeoPoint(int latitudeE6, int longitudeE6) {
    }
}

class OverlayItem {
    public OverlayItem(GeoPoint point, String title, String snippet) {
    }
}

class LatLng {
    private double lat;
    private double lon;

    public LatLng(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}

class Overlay {
}