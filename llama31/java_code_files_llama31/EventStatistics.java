/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventStatistics {
    private final ConcurrentLinkedQueue<Event> queue;
    private final int maxSeconds;
    private int failureCount;
    private int totalCount;

    public EventStatistics(int n) {
        this.maxSeconds = n;
        this.queue = new ConcurrentLinkedQueue();
    }

    public void addEvent(Event event) {
        this.queue.add(event);
        if (event.getType() == Event.Type.FAILURE) {
            ++this.failureCount;
        }
        ++this.totalCount;
        while (!this.queue.isEmpty() && this.queue.peek().getTimestamp() < System.currentTimeMillis() - (long)(this.maxSeconds * 1000)) {
            Event event2 = this.queue.poll();
            if (event2.getType() == Event.Type.FAILURE) {
                --this.failureCount;
            }
            --this.totalCount;
        }
    }

    public double getAverageFailureRate() {
        return (double)this.failureCount / (double)this.totalCount;
    }

    public static void main(String[] stringArray) {
    }

    public static class Event {
        private final Type type;
        private final long timestamp;

        public Event(Type type) {
            this.type = type;
            this.timestamp = System.currentTimeMillis();
        }

        public Type getType() {
            return this.type;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public static enum Type {
            SUCCESS,
            FAILURE;

        }
    }
}
