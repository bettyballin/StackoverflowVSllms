// Define the Event class
class Event {
    private long id;
    private int value;

    public Event(long id, int value) {
        this.id = id;
        this.value = value;
    }
}

public class EventListOrEventArray {
    Event[] events = new Event[] {
        new Event(0L, 0),
        new Event(1L, 1),
        new Event(1L, 2),
        new Event(2L, 3)
    };

    public static void main(String[] args) {
        // Create an instance of the class to avoid the 'events' array being garbage collected
        EventListOrEventArray eventListOrEventArray = new EventListOrEventArray();
    }
}