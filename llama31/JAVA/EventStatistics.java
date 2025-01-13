import java.lang.String;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventStatistics {
    private final ConcurrentLinkedQueue<Event> queue;
    private final int maxSeconds;
    private int failureCount;
    private int totalCount;

    public EventStatistics(int maxSeconds) {
        this.maxSeconds = maxSeconds;
        this.queue = new ConcurrentLinkedQueue<>();
    }

    public void addEvent(Event event) {
        queue.add(event);
        if (event.getType() == Event.Type.FAILURE) {
            failureCount++;
        }
        totalCount++;

        // Remove old events
        while (!queue.isEmpty() && queue.peek().getTimestamp() < System.currentTimeMillis() - maxSeconds * 1000) {
            Event oldEvent = queue.poll();
            if (oldEvent.getType() == Event.Type.FAILURE) {
                failureCount--;
            }
            totalCount--;
        }
    }

    public double getAverageFailureRate() {
        return (double) failureCount / totalCount;
    }

    public static class Event {
        private final Type type;
        private final long timestamp;

        public Event(Type type) {
            this.type = type;
            this.timestamp = System.currentTimeMillis();
        }

        public Type getType() {
            return type;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public enum Type {
            SUCCESS,
            FAILURE
        }
    }

	public static void main(String[] args) {
	}
}