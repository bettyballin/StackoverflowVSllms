public class CustomZoomableMapFragment extends SupportMapFragment {
    private static final String TAG = "CustomMapFragment";

    public CustomZoomableMapFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true); // Optional, but true by default!
        GoogleMapOptions options = new GoogleMapOptions();
        Context context = getContext();
        if (context != null) {
            this.getMapAsync(options, context);
        } else {
            Log.wtf("null", "Failed to set map with gesture detector: context is 'null'");
        }
    }

    private GoogleMap mMap; // make sure in your case it points to the proper instance of map!
    @Override
    public void onResume() {
        super.onResume();
        if (mMap != null) return;

        // Initialize Zoom Gesture listener using new map object from Google API
        this.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                if (googleMap == null){ throw new RuntimeException("Error getting maps"); }

                // Create Zoom Gesture Detector using map object.
                zoomGesturesUsingGMAPI(mMap);
            }
        });
    }

    private static void zoomGesturesUsingGMAPI (GoogleMap mMap) {
        /* Note: Google Maps API already provides support for pinch-to-zoom functionality.
         * There is no need to add custom gesture detector. Just make sure
         * MapView/MapFragment has enough space in parent layout and that it's not overlaid by other views */
          // No need to override touch if using API v2!
    }

    public static void main(String[] args) {
        // Entry point for the Java application
        CustomZoomableMapFragment fragment = new CustomZoomableMapFragment();
        fragment.onCreate(new Bundle());
        fragment.onResume();
    }

    // Stub methods to allow compilation
    public void getMapAsync(GoogleMapOptions options, Context context) {}

    public void getMapAsync(OnMapReadyCallback callback) {}

    public Context getContext() { return new Context(); }

    public void setRetainInstance(boolean retain) {}

    public void onCreate(Bundle savedInstanceState) {}

    public void onResume() {}
}

// Stub classes to allow compilation
class Bundle {}

class GoogleMap {}

interface OnMapReadyCallback {
    void onMapReady(GoogleMap googleMap);
}

class MotionEvent {}

class Context {}

class Log {
    public static void wtf(String tag, String msg) {
        System.out.println(tag + ": " + msg);
    }
}

class GoogleMapOptions {}

class SupportMapFragment {
    public void getMapAsync(GoogleMapOptions options, Context context) {}

    public void getMapAsync(OnMapReadyCallback callback) {}

    public Context getContext() { return null; }

    public void setRetainInstance(boolean retain) {}

    public void onCreate(Bundle savedInstanceState) {}

    public void onResume() {}
}