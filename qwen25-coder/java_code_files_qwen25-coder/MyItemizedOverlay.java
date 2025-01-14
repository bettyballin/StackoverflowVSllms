import java.util.List;
import java.util.ArrayList;

// Dummy classes to represent Android classes
class Resources {
  public Drawable getDrawable(int id) {
    return new Drawable();
  }
}

class Drawable {
  // Empty class for Drawable
}

class MapView {
  public List<Overlay> getOverlays() {
    return new ArrayList<Overlay>();
  }
  public void postInvalidate() {
    // Do nothing
  }
}

class Overlay {
  // Empty class for Overlay
}

class OverlayItem {
  public OverlayItem(GeoPoint point, String title, String snippet) {
    // Constructor
  }
}

class GeoPoint {
  public GeoPoint(int latitudeE6, int longitudeE6) {
    // Constructor
  }
}

class ItemizedOverlay<T> extends Overlay {
  public ItemizedOverlay(Drawable defaultMarker) {
    // Constructor
  }
  protected void populate() {
    // Method stub
  }
  public T getItem(int index) {
    return null;
  }
  public void setFocus(T item) {
    // Method stub
  }
}

// Dummy Log class to simulate android.util.Log
class Log {
  public static void d(String tag, String msg) {
    System.out.println(tag + ": " + msg);
  }
}

// Dummy R class to simulate resources
class R {
  public static class drawable {
    public static final int icon = 0;
  }
  public static class id {
    public static final int mymapview = 0;
  }
}

// Utility method
static Drawable boundsCenterBottom(Drawable drawable) {
  // For this mock, just return the drawable
  return drawable;
}

// MyItemizedOverlay class as per the original code
public class MyItemizedOverlay extends ItemizedOverlay<OverlayItem> {
  public MyItemizedOverlay(Drawable defaultMarker) {
    super(boundsCenterBottom(defaultMarker)); // Important to center the icon properly
    populate();
  }

  @Override
  protected OverlayItem createItem(int index) {
    Double lat = (index + 37.422006) * 1E6;
    Double lng = -122.084095 * 1E6;
    GeoPoint point = new GeoPoint(lat.intValue(), lng.intValue());

    OverlayItem oi = new OverlayItem(point, "Marker", "Marker Text");
    return oi;
  }

  @Override
  public int size() {
    return 5; // Number of markers you want to add
  }

  public static void main(String[] args) {
    // Empty main method
  }
}

// Main class to encapsulate the methods
public class Main {
  public static void main(String[] args) {
    Main main = new Main();
    main.addItemizedOverlay();
  }

  private void addItemizedOverlay() {
    Resources r = getResources();
    MapView mapView = (MapView) findViewById(R.id.mymapview);
    List<Overlay> overlays = mapView.getOverlays();

    MyItemizedOverlay markers = new MyItemizedOverlay(r.getDrawable(R.drawable.icon));
    overlays.add(markers);

    // Log to verify the item is added
    Log.d("MyApp", "Added ItemizedOverlay with " + markers.size() + " items");

    OverlayItem oi = markers.getItem(0);
    markers.setFocus(oi);
    mapView.postInvalidate();
  }

  // Method stubs to simulate Android Context methods
  public Resources getResources() {
    return new Resources();
  }

  public Object findViewById(int id) {
    return new MapView();
  }
}