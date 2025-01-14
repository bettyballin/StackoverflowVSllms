import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        // Code to test the implementation
        MyContainer<String> container = new MyContainer<>();

        // Create an observer and add it to the container
        ObserverImpl observer = new ObserverImpl();
        container.addObserver(observer);

        // Add and remove items to/from the container
        container.addItem("Item1");
        container.addItem("Item2");
        container.removeItem(0);
    }
}

class MyContainer<T> extends Observable {
    private List<T> elements = new LinkedList<>();

    public void addItem(T item) {
        elements.add(item);
        setChanged();
        notifyObservers(new ChangeEvent<>(this, "Added", item));
    }

    public void removeItem(int index) {
        if (index >= 0 && index < elements.size()) {
            T removedElement = elements.remove(index);
            setChanged();
            notifyObservers(new ChangeEvent<>(this, "Removed", removedElement));
        }
    }

    // More methods as needed, e.g., updateItem

    public List<T> getElements() {
        return elements;
    }
}

class ObserverImpl implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof ChangeEvent) {
            ChangeEvent<?> event = (ChangeEvent<?>) arg;
            System.out.println("Change detected: " + event.getType() + ", item: " + event.getItem());
            // Handle specific actions based on the type of change and the item
        }
    }
}

class ChangeEvent<T> {
    private final Object source;
    private final String type; // e.g., "Added", "Removed"
    private final T item;

    public ChangeEvent(Object source, String type, T item) {
        this.source = source;
        this.type = type;
        this.item = item;
    }

    public Object getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public T getItem() {
        return item;
    }
}