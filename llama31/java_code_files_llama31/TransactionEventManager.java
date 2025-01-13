/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.TreeMap;

public class TransactionEventManager {
    private TreeMap<Long, Integer> transactionIdMap = new TreeMap();
    private ArrayList<TransactionEvent> list = new ArrayList();

    public void addTransactionEvent(TransactionEvent transactionEvent) {
        int n = this.list.size();
        this.list.add(transactionEvent);
        this.transactionIdMap.put(transactionEvent.getTransactionId(), n);
    }

    public TransactionEvent getTransactionEvent(Long l) {
        Integer n = this.transactionIdMap.get(l);
        if (n != null) {
            return this.list.get(n);
        }
        for (TransactionEvent transactionEvent : this.list) {
            if (!transactionEvent.getTransactionId().equals(l)) continue;
            return transactionEvent;
        }
        return null;
    }

    public static void main(String[] stringArray) {
        TransactionEventManager transactionEventManager = new TransactionEventManager();
        TransactionEvent transactionEvent = new TransactionEvent(1L);
        transactionEventManager.addTransactionEvent(transactionEvent);
        System.out.println(transactionEventManager.getTransactionEvent(1L).getTransactionId());
    }
}
