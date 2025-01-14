import java.util.*;

class Event {
    private String name;
    private long time;

    public Event(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Event | " + name + "\n  Time: " + (time / 3600000) + ":" + ((time % 3600000) / 60000);
    }
}

public class EventSorter {
    private static final String SORT_DESCENDING = "DESC";

    public static void main(String[] args) {
        List<Event> events = new ArrayList<>(Arrays.asList(
            new Event("A", 0),
            new Event("B", 60000), // 0:01
            new Event("C", 60000), // 0:01
            new Event("D", 120000) // 0:02
        ));

        String _sortOrder = SORT_DESCENDING;

        if (SORT_DESCENDING.equals(_sortOrder)) {
            // Shuffle the list to break original order
            Collections.shuffle(events);
            events.sort((e1, e2) -> Long.compare(e2.getTime(), e1.getTime()));
        } else {
            events.sort(Comparator.comparingLong(Event::getTime));
        }

        for (Event event : events) {
            System.out.println(event.toString());
        }
    }
}