import java.lang.String;
import java.util.ArrayDeque;
import java.util.Queue;

public class EventStatistics {
    private final Queue<Event> eventQueue = new ArrayDeque<>();
    private int failureCount = 0;
    private long windowDurationMillis;

    public EventStatistics(long windowDurationSeconds) {
        this.windowDurationMillis = windowDurationSeconds * 1000;
    }

    public void addEvent(boolean isSuccess) {
        long now = System.currentTimeMillis();
        Event event = new Event(now, !isSuccess);
        if (!event.isSuccess) failureCount++;
        eventQueue.add(event);

        // Remove events outside of the sliding window
        while (!eventQueue.isEmpty() && now - eventQueue.peek().timestamp > windowDurationMillis) {
            Event expiredEvent = eventQueue.poll();
            if (!expiredEvent.isSuccess) failureCount--;
        }
    }

    public double getFailureRate() {
        int totalEvents = eventQueue.size();
        return totalEvents == 0 ? 0 : (double) failureCount / totalEvents;
    }

    private static class Event {
        long timestamp;
        boolean isSuccess;

        Event(long timestamp, boolean isFailure) {
            this.timestamp = timestamp;
            this.isSuccess = !isFailure;
        }
    }

    public static void main(String[] args) {
        EventStatistics stats = new EventStatistics(10); // 10 seconds window
        for (int i = 0; i < 20; i++) { // Simulate adding events
            boolean isSuccess = i % 3 != 0; // Some fails, some successes
            stats.addEvent(isSuccess);
            System.out.println("Failure Rate: " + stats.getFailureRate());
        }
    }
}