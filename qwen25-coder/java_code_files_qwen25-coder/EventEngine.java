// Define an abstract event handler class
abstract class EventHandler {
    public abstract void handleEvent(String event);
}

// Define an engine that uses the EventHandler
public class EventEngine {
    private final EventHandler eventHandler;

    // Constructor for dependency injection
    public EventEngine(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    // Method to simulate firing events which in turn calls the handleEvent method of the handler
    public void fireEvent(String event) {
        eventHandler.handleEvent(event);
    }

    public static void main(String[] args) {
    }
}