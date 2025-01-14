public abstract class EventHandler {
    public abstract void handleEvent(String event);
}

// Implement the abstract handler with specific behavior
public class ConcreteEventHandler extends EventHandler {
    @Override
    public void handleEvent(String event) {
        System.out.println("Handling event: " + event);
    }

    // Factory method or service locator pattern
    public static class HandlerFactory {
        // This could be more sophisticated, checking configuration for different implementations
        public static EventHandler createEventHandler() {
            return new ConcreteEventHandler();
        }
    }
}

public class EventEngine {
    private EventHandler handler;

    public EventEngine(EventHandler handler) {
        this.handler = handler;
    }

    public void fireEvent(String event) {
        handler.handleEvent(event);
    }
}

// Main class to run the engine with concrete implementation
public class Main {
    public static void main(String[] args) {
        // Registering the implementation using factory method
        EventHandler handler = ConcreteEventHandler.HandlerFactory.createEventHandler();

        // Initialize and start running the event engine
        EventEngine engine = new EventEngine(handler);
        engine.fireEvent("Test Event");
    }
}