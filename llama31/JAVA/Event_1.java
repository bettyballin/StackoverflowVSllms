// Define the Event class
public class Event_1 {
    private String type;
    private Object data;

    public Event(String type, Object data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public Object getData() {
        return data;
    }
}

// Define the Plugin interface
public interface Plugin {
    void start();
    void stop();
    void handleEvent(Event event);
}

// Define the Event_1 class (which seems to be a duplicate of the Event class)
public class Event_1_1 {
    private String type;
    private Object data;

    public Event_1(String type, Object data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    public static void main(String[] args) {
        // You can add code here to test the classes
    }
}