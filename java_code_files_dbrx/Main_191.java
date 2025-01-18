import java.util.Comparator;
import java.util.PriorityQueue;
import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        // Define your comparator for ordering the queue based on priorities
        Comparator<Request> requestComparator = new Comparator<Request>() {
            @Override
            public int compare(Request reqA, Request reqB){
                return reqB.priority.compareTo(reqA.priority); // Adjust accordingly if lower priority should be processed first
            }
        };
        // Initialize the queue with request comparator for ordering elements based on priorities.
        PriorityQueue<Request> requests = new PriorityQueue<>(10, requestComparator);
    }

    static class Request {
        public int cellIdA, cellIdB; // Ids of requests cells A and B to switch places
        public Priority priority;  // Priority of said request (higher value = higher priority)
    }

    enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }
}