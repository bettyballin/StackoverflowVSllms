import java.lang.String;

public class GeoLocationUpdater {

    // Instance variable
    private NetworkController m_pNetworkCtrl = new NetworkController();

    // Annotate your methods with @Subscribe as a way of registering them to specific events
    @Subscribe(threadMode = ThreadMode.MAIN)    // Run on UI thread (default behavior)
    public void onRecordStartEvent(RecordStartEvent event) {
        m_pNetworkCtrl.SetGeoLocationInfo();     // Execute your action here instead of OnRecordStart method
    }

    public static void main(String[] args) {
    }
}

// Annotation
@interface Subscribe {
    ThreadMode threadMode() default ThreadMode.MAIN;
}

// Enum
enum ThreadMode {
    MAIN,
    BACKGROUND,
    ASYNC
}

// RecordStartEvent class
class RecordStartEvent {
    // Empty class
}

// NetworkController class
class NetworkController {
    public void SetGeoLocationInfo() {
        // Do something
    }
}