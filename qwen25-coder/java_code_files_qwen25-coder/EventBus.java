import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class EventBus {
    private final Map<Class<? extends Event>, List<EventListener>> listeners = new HashMap<>();

    public <T extends Event> void subscribe(Class<T> eventType, EventListener<T> listener) {
        listeners.computeIfAbsent(eventType, c -> new ArrayList<>()).add(listener);
    }

    @SuppressWarnings("unchecked")
    public void publish(Event event) {
        for (EventListener listener : listeners.getOrDefault(event.getClass(), List.of())) {
            ((EventListener<Event>) listener).onEvent(event);
        }
    }

    public static void main(String[] args) {
    }
}

interface EventListener<T extends Event> {
    void onEvent(T event);
}

class Event {
}