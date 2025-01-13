import java.sql.SQLException;

public class TransactionExecutor {
    private static final int MAX_RETRIES = 3; // Define MAX_RETRIES

    public void executeTransaction() throws Exception { // Declare throws Exception
        int retryCount = 0;
        while (retryCount < MAX_RETRIES) {
            try {
                // Execute transaction
                beginTransaction();
                // Perform database operations
                commitTransaction();
                break;
            } catch (SQLException e) {
                if (e.getSQLState().equals("40001")) { // Deadlock detected
                    retryCount++;
                    // Retry after a short delay
                    Thread.sleep(100);
                } else {
                    // Handle other SQL exceptions
                    throw e;
                }
            }
        }
        if (retryCount >= MAX_RETRIES) {
            // Handle failure after max retries
            throw new Exception("Transaction failed after " + MAX_RETRIES + " retries");
        }
    }

    private void beginTransaction() throws SQLException { // Declare throws SQLException
        // Implement beginTransaction logic
    }

    private void commitTransaction() throws SQLException { // Declare throws SQLException
        // Implement commitTransaction logic
    }

    public static void main(String[] args) {
        TransactionExecutor executor = new TransactionExecutor();
        try {
            executor.executeTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}