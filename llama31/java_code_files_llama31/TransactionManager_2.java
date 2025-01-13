/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class TransactionManager_2 {
    public static void main(String[] stringArray) {
        String string = UUID.randomUUID().toString();
        String string2 = TransactionManager_2.storeTransactionIdInDatabase(string);
        TransactionManager_2.passTransactionIdToAnotherApplication(string);
        if (!string.equals(string2)) {
            TransactionManager_2.rollbackTransaction();
            throw new RuntimeException("Transaction ID mismatch");
        }
        TransactionManager_2.commitTransaction();
    }

    private static String storeTransactionIdInDatabase(String string) {
        return string;
    }

    private static void passTransactionIdToAnotherApplication(String string) {
    }

    private static void rollbackTransaction() {
    }

    private static void commitTransaction() {
    }
}
