import java.io.IOException;

// Network code
public class NetworkConnector {
    public void connect() throws IOException {
        // connection logic
    }
}

// Business logic
public class DataLoader {
    private NetworkConnector connector;

    public void loadData() throws NoConnectionException {
        try {
            connector.connect();
        } catch (IOException e) {
            throw new NoConnectionException("Failed to establish connection", e);
        }
    }

    public static void main(String[] args) {
        // Added a main method to make the code executable
        DataLoader dataLoader = new DataLoader();
        dataLoader.connector = new NetworkConnector();
        try {
            dataLoader.loadData();
        } catch (NoConnectionException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Custom exception
class NoConnectionException extends Exception {
    public NoConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}