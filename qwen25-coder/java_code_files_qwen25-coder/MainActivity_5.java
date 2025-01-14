public class MainActivity_5 extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        // Log an app event using a custom event name and params bundle
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "DroidInTweet1");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "tweet");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    public static void main(String[] args) {
        // Create an instance and call onCreate method
        MainActivity_5 activity = new MainActivity_5();
        activity.onCreate(new Bundle());
    }
}

// Stub classes to mimic Android framework and FirebaseAnalytics

class AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        // Stub method
    }

    protected void setContentView(int layoutResID) {
        // Stub method
    }
}

class Bundle {
    public void putString(String key, String value) {
        // Stub method
    }
}

class R {
    public static final class layout {
        public static final int activity_main = 0;
    }
}

class FirebaseAnalytics {
    public static class Param {
        public static final String ITEM_ID = "item_id";
        public static final String ITEM_NAME = "item_name";
        public static final String CONTENT_TYPE = "content_type";
    }

    public static class Event {
        public static final String SELECT_CONTENT = "select_content";
    }

    public static FirebaseAnalytics getInstance(AppCompatActivity activity) {
        return new FirebaseAnalytics();
    }

    public void logEvent(String eventName, Bundle params) {
        // Stub method to simulate logging
        System.out.println("Event logged: " + eventName);
    }
}