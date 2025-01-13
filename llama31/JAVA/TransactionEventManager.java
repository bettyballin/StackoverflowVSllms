import java.util.TreeMap;
import java.util.ArrayList;

class TransactionEvent {
    private Long transactionId;

    public Long getTransactionId() {
        return transactionId;
    }

    public TransactionEvent(Long transactionId) {
        this.transactionId = transactionId;
    }
}

public class TransactionEventManager {
    private TreeMap<Long, Integer> transactionIdMap = new TreeMap<>();
    private ArrayList<TransactionEvent> list = new ArrayList<>();

    // When adding a new TransactionEvent to the list
    public void addTransactionEvent(TransactionEvent event) {
        // Add the event to the list
        int index = list.size();
        list.add(event);

        // Update the map
        transactionIdMap.put(event.getTransactionId(), index);
    }

    // When looking up a TransactionEvent by transaction ID
    public TransactionEvent getTransactionEvent(Long transactionId) {
        Integer index = transactionIdMap.get(transactionId);
        if (index != null) {
            return list.get(index);
        } else {
            // Perform a linear search if the ID is not in the map
            for (TransactionEvent event : list) {
                if (event.getTransactionId().equals(transactionId)) {
                    return event;
                }
            }
            return null; // Not found
        }
    }

    public static void main(String[] args) {
        TransactionEventManager manager = new TransactionEventManager();
        TransactionEvent event = new TransactionEvent(1L);
        manager.addTransactionEvent(event);
        System.out.println(manager.getTransactionEvent(1L).getTransactionId());  // prints: 1
    }
}