import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// The container class
class Container<T> {
    private List<T> elements = new ArrayList<>();

    public void add(T element) {
        elements.add(element);
    }

    public void remove(T element) {
        elements.remove(element);
    }

    public Iterator<T> iterator() {
        return elements.iterator();
    }
}

// The wrapper class that manages the container and observers
class ContainerWrapper<T> {
    private Container<T> container;
    private List<Observer<T>> observers = new ArrayList<>();

    public ContainerWrapper(Container<T> container) {
        this.container = container;
    }

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void add(T element) {
        container.add(element);
        notifyObservers(element, EventType.ADD);
    }

    public void remove(T element) {
        container.remove(element);
        notifyObservers(element, EventType.REMOVE);
    }

    private void notifyObservers(T element, EventType eventType) {
        for (Observer<T> observer : observers) {
            observer.update(element, eventType);
        }
    }
}

// The observer interface
interface Observer<T> {
    void update(T element, EventType eventType);
}

// The event type enum
enum EventType {
    ADD,
    REMOVE,
    UPDATE
}

public class class_1_1 {
    public static void main(String[] args) {
    }
}