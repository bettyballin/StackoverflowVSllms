import java.util.ArrayList;
import java.util.List;

class Event {
    int priority;
    double duration;
    double earliestTime;

    Event(int priority, double duration, double earliestTime) {
        this.priority = priority;
        this.duration = duration;
        this.earliestTime = earliestTime;
    }
}

public class EventSorter {
    public static List<Event> sort(List<Event> events) {
        List<Event> sortedEvents = new ArrayList<>();
        double currentTime = 0.0;

        for (Event event : events) {
            // Find the correct position for the event
            int index = 0;
            while (index < sortedEvents.size() && sortedEvents.get(index).priority < event.priority) {
                index++;
            }

            // Check if the event can be inserted at the found position
            if (index == 0 || sortedEvents.get(index - 1).earliestTime + sortedEvents.get(index - 1).duration <= event.earliestTime) {
                sortedEvents.add(index, event);
            } else {
                // Find the first position where the event can be inserted
                index = 0;
                while (index < sortedEvents.size() && sortedEvents.get(index).earliestTime + sortedEvents.get(index).duration < event.earliestTime) {
                    index++;
                }
                sortedEvents.add(index, event);
            }

            // Update the current time
            if (sortedEvents.size() > 0) {
                currentTime = sortedEvents.get(sortedEvents.size() - 1).earliestTime + sortedEvents.get(sortedEvents.size() - 1).duration;
            }
        }

        return sortedEvents;
    }

	public static void main(String[] args) {
		// Example usage
		List<Event> events = new ArrayList<>();
		events.add(new Event(1, 2.0, 1.0));
		events.add(new Event(2, 1.0, 3.0));
		events.add(new Event(3, 3.0, 2.0));
		
		List<Event> sortedEvents = sort(events);
		for (Event event : sortedEvents) {
			System.out.println("Priority: " + event.priority + ", Duration: " + event.duration + ", Earliest Time: " + event.earliestTime);
		}
	}
}