/*
 * Decompiled with CFR 0.152.
 */
import java.sql.SQLException;

public class TransactionExecutor {
    private static final int MAX_RETRIES = 3;

    public void executeTransaction() throws Exception {
        int n;
        for (n = 0; n < 3; ++n) {
            try {
                this.beginTransaction();
                this.commitTransaction();
                break;
            }
            catch (SQLException sQLException) {
                if (sQLException.getSQLState().equals("40001")) {
                    Thread.sleep(100L);
                    continue;
                }
                throw sQLException;
            }
        }
        if (n >= 3) {
            throw new Exception("Transaction failed after 3 retries");
        }
    }

    private void beginTransaction() throws SQLException {
    }

    private void commitTransaction() throws SQLException {
    }

    public static void main(String[] stringArray) {
        TransactionExecutor transactionExecutor = new TransactionExecutor();
        try {
            transactionExecutor.executeTransaction();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
