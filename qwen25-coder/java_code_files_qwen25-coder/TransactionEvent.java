import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class TransactionEvent {
    private int transactionId;
    // other properties

    public TransactionEvent(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionId() {
        return transactionId;
    }
}

public class TransactionManager {
    private List<TransactionEvent> events;

    public TransactionManager() {
        this.events = new ArrayList<>();
    }

    public void add(TransactionEvent event) {
        events.add(event);
    }

    public void sortEvents() {
        events.sort(Comparator.comparingInt(TransactionEvent::getTransactionId));
    }

    public TransactionEvent find(int transactionId) {
        int index = Collections.binarySearch(events, new SimpleTransaction(transactionId),
                Comparator.comparingInt(TransactionEvent::getTransactionId));

        if (index >= 0) {
            return events.get(index);
        } else {
            // Calculate the insertion point
            index = -(index + 1);

            // Perform a limited linear search around the calculated index
            // Adjust the window as per your data distribution pattern or testing results
            int start = Math.max(0, index - 50);
            int end = Math.min(events.size(), index + 50);

            for (int i = start; i < end; i++) {
                if (events.get(i).getTransactionId() == transactionId) {
                    return events.get(i);
                }
            }

            // Not found
            return null;
        }
    }

    private static class SimpleTransaction extends TransactionEvent {
        public SimpleTransaction(int transactionId) {
            super(transactionId);
        }
    }

    public static void main(String[] args) {
        TransactionManager manager = new TransactionManager();
        // Add events to the manager
        manager.add(new TransactionEvent(10000));
        manager.add(new TransactionEvent(15000));
        manager.add(new TransactionEvent(12345));
        manager.add(new TransactionEvent(20000));
        manager.add(new TransactionEvent(25000));

        // Sort events before searching
        manager.sortEvents();

        TransactionEvent event = manager.find(12345); // Replace with actual ID you're searching for
        if (event != null) {
            System.out.println("Found: " + event.getTransactionId());
        } else {
            System.out.println("Not found");
        }
    }
}