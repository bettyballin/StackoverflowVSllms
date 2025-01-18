import java.lang.String;

public class ButtonClickListener {
    public void onButtonClick(View view) {
        EventBus.getDefault().post(new RecordStartEvent());  //Post your custom message for subscribed methods to receive
    }
    public static void main(String[] args) {
    }
}

class View {
    // Placeholder for View class
}

class EventBus {
    private static EventBus instance = new EventBus();

    public static EventBus getDefault() {
        return instance;
    }

    public void post(Object event) {
        // Placeholder method
    }
}

class RecordStartEvent {
    // Placeholder for RecordStartEvent class
}