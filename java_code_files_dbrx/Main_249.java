import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

// Assuming you have the Trove library in your classpath

public class Main {
    public static void main(String[] args) {
        // Initialize Map
        TIntObjectMap<TransactionEvent> m = new TIntObjectHashMap<>();

        // Create a TransactionEvent (Assuming you get this id from your TransactionEvent object)
        TransactionEvent transactionEvent = new TransactionEvent(123);

        // Adding elements to map
        m.put(transactionEvent.getTransactionId(), transactionEvent);
    }
}

class TransactionEvent {
    private int transactionId;

    public TransactionEvent(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionId() {
        return transactionId;
    }
}