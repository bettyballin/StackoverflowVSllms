import java.io.IOException;

public class NetworkService {
    public void connectToServer(String serverUrl) throws NoConnectionException {
        try {
            // Code to connect to the server
        } catch (IOException e) {
            throw new NoConnectionException("Failed to connect to server: " + serverUrl, e);
        }
    }
}

class NoConnectionException extends Exception {
    public NoConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void main(String[] args) {
    }
}