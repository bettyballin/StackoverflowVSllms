import java.util.Map;
import java.util.HashMap;

// Project A (abstract class and engine)
public abstract class EventHandler {
    public abstract void handleEvent(String event);
}

public class Engine {
    private EventHandler eventHandler;

    public Engine(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void fireEvent(String event) {
        eventHandler.handleEvent(event);
    }
}

// Project B (implementation and registry)
class MyEventHandler extends EventHandler {
    @Override
    public void handleEvent(String event) {
        System.out.println("Handling event: " + event);
    }
}

class EventHandlerRegistry {
    private static final Map<Class<? extends EventHandler>, EventHandler> registry = new HashMap<>();

    public static void registerEventHandler(Class<? extends EventHandler> clazz, EventHandler instance) {
        registry.put(clazz, instance);
    }

    public static EventHandler getEventHandler(Class<? extends EventHandler> clazz) {
        return registry.get(clazz);
    }
}

public class Main {
    public static void main(String[] args) {
        // Register the implementation
        EventHandlerRegistry.registerEventHandler(MyEventHandler.class, new MyEventHandler());

        // Create the engine with the registered implementation
        Engine engine = new Engine(EventHandlerRegistry.getEventHandler(MyEventHandler.class));

        // Fire an event
        engine.fireEvent("Hello, World!");
    }
}