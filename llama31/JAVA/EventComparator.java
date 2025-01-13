import java.lang.String;
import java.lang.Integer;

public class EventComparator {
    private static final String SORT_DESCENDING = "DESCENDING"; // Assuming this is the value for descending order
    private String _sortOrder; // This field was missing in the original code

    public EventComparator(String sortOrder) {
        this._sortOrder = sortOrder;
    }

    public int compare(Event e1, Event e2) {
        // Reverse sorting.
        if (SORT_DESCENDING.equals(_sortOrder)) {
            int timeComparison = Long.compare(e2.getTime(), e1.getTime());
            if (timeComparison == 0) {
                // If time values are equal, compare original indices in reverse order
                return Integer.compare(e2.getOriginalIndex(), e1.getOriginalIndex());
            } else {
                return timeComparison;
            }
        }

        return Long.compare(e1.getTime(), e2.getTime());
    }

    public static void main(String[] args) {
        EventComparator comparator = new EventComparator("DESCENDING");
        // You need to create Event objects to compare
        // Event e1 = new Event(...);
        // Event e2 = new Event(...);
        // int result = comparator.compare(e1, e2);
    }
}

class Event {
    private long time;
    private int originalIndex;

    public Event(long time, int originalIndex) {
        this.time = time;
        this.originalIndex = originalIndex;
    }

    public long getTime() {
        return time;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }
}