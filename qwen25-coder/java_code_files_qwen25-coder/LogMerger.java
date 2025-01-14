import java.io.*;
import java.util.*;

class Event implements Comparable<Event> {
    long timestamp;
    String details;

    public Event(long timestamp, String details) {
        this.timestamp = timestamp;
        this.details = details;
    }

    @Override
    public int compareTo(Event e) {
        return Long.compare(this.timestamp, e.timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;
        return timestamp == event.timestamp && details.equals(event.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, details);
    }
}

public class LogMerger {

    public static void mergeLogs(List<String> logFileNames, String outputFile) throws IOException {
        PriorityQueue<EventWithIndex> minHeap = new PriorityQueue<>();
        Map<Integer, BufferedReader> readersMap = new HashMap<>();
        Set<Event> seenEvents = new HashSet<>();

        // Initialize the heap with the first event of each file
        for (int i = 0; i < logFileNames.size(); i++) {
            String fileName = logFileNames.get(i);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            readersMap.put(i, reader);
            Event event = readEvent(reader);
            if (event != null) minHeap.add(new EventWithIndex(event, i));
        }

        // Merge the events
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        try {
            while (!minHeap.isEmpty()) {
                EventWithIndex current = minHeap.poll();
                Event event = current.event;
                if (!seenEvents.add(event)) continue; // Skip if already seen

                writer.write(event.details);
                writer.newLine();

                BufferedReader reader = readersMap.get(current.index);
                Event nextEvent = readEvent(reader);
                if (nextEvent != null) {
                    minHeap.add(new EventWithIndex(nextEvent, current.index));
                }
            }
        } finally {
            // Close all readers and writer
            writer.close();
            for (BufferedReader reader : readersMap.values()) {
                reader.close();
            }
        }
    }

    private static Event readEvent(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null) return null;
        String[] parts = line.split(" ", 2); // Adjust based on your log format
        long timestamp = Long.parseLong(parts[0]);
        String details = parts[1];
        return new Event(timestamp, details);
    }

    static class EventWithIndex implements Comparable<EventWithIndex> {
        Event event;
        int index;

        public EventWithIndex(Event event, int index) {
            this.event = event;
            this.index = index;
        }

        @Override
        public int compareTo(EventWithIndex other) {
            return this.event.compareTo(other.event);
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> logFileNames = Arrays.asList("log1.txt", "log2.txt"); // Add your log file names here
        String outputFile = "merged_log.txt";
        mergeLogs(logFileNames, outputFile);
    }
}