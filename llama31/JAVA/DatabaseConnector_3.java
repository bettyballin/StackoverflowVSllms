import java.sql.SQLException;

public class DatabaseConnector_3_3 {
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY = 500; // milliseconds

    public void executeQuery(String query) {
        int retries = 0;
        while (retries < MAX_RETRIES) {
            try {
                // Execute the query using TQuery
                // NOTE: You need to implement the actual query execution here
                // For now, I'll just comment it out to make the code compile
                // TQuery.executeQuery(query);
                break; // Query executed successfully
            } catch (SQLException e) {
                if (e.getErrorCode() == 17002) { // ORA-17002: IO Exception
                    retries++;
                    try {
                        Thread.sleep(RETRY_DELAY);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    throw e; // Rethrow other SQL exceptions
                }
            }
        }
    }

    public static void main(String[] args) {
        DatabaseConnector_3 connector = new DatabaseConnector_3();
        connector.executeQuery("SELECT * FROM dual");
    }
}