import java.util.concurrent.atomic.AtomicBoolean;
import java.util.ArrayList;
import java.util.List;

// Thread-safe UI component
class Button {
    private AtomicBoolean enabled = new AtomicBoolean(true);

    public void setEnabled(boolean enabled) {
        this.enabled.set(enabled);
    }

    public boolean isEnabled() {
        return enabled.get();
    }
}

// Event class
class Event {
    private String type;

    public Event(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

// Event handler registration
interface EventHandler {
    void handleEvent(Event event);
}

class UI {
    private Button button;
    private List<EventHandler> handlers = new ArrayList<>();

    public UI() {
        this.button = new Button();
    }

    public Button getButton() {
        return button;
    }

    public void registerEventHandler(EventHandler handler) {
        // Add handler to list of registered handlers
        handlers.add(handler);
    }

    public void fireEvent(Event event) {
        // Notify all registered handlers
        for (EventHandler handler : handlers) {
            handler.handleEvent(event);
        }
    }
}

// Example usage
class MyThread extends Thread {
    private UI ui;

    public MyThread(UI ui) {
        this.ui = ui;
    }

    @Override
    public void run() {
        // Update UI component
        ui.getButton().setEnabled(false);

        // Fire event
        ui.fireEvent(new Event("Button clicked"));
    }
}

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        MyThread thread = new MyThread(ui);
        thread.start();
    }
}