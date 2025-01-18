import java.lang.String;
public class EventSubscriberActivity extends BaseActivity {
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);  //Register this as a subscriber to receive messages
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);   //Unregister this so that it doesn't get event anymore
    }

    public static void main(String[] args) {
    }
}

class BaseActivity {
    public void onStart() {}
    public void onStop() {}
}

class EventBus {
    private static EventBus defaultInstance = new EventBus();

    public static EventBus getDefault() {
        return defaultInstance;
    }

    public void register(Object o) {}
    public void unregister(Object o) {}
}