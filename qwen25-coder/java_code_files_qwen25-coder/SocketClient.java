enum ResponseCode {
    OK,
    Fail,
    Fault // Used only when an exception is thrown
}

public class SocketClient {
    public ResponseCode syncCommand(String command) {
        try {
            sendToServer(command);
            String response = receiveFromServer();
            return parseResponse(response); // Maps server's response to OK or Fail
        } catch (Exception e) {
            throw new FaultException("Network fault occurred", e);
        }
    }

    private void sendToServer(String command) {
        // Stub method: Logic to send command to server
    }

    private String receiveFromServer() {
        // Stub method: Logic to receive response from server
        return "OK"; // Placeholder response
    }

    private ResponseCode parseResponse(String response) {
        // Logic to convert server's response into ResponseCode
        return ("OK".equals(response)) ? ResponseCode.OK : ResponseCode.Fail;
    }

    public void asyncCommand(String command, Callback callback) {
        try {
            sendAsyncToServer(command);
        } catch (Exception e) {
            callback.onError(new FaultException("Network fault occurred", e));
        }
    }

    private void sendAsyncToServer(String command) {
        // Stub method: Logic to send command to server asynchronously
    }

    public static void main(String[] args) {
        // Test code
    }
}

class FaultException extends RuntimeException {
    public FaultException(String message, Throwable cause) {
        super(message, cause);
    }
}

interface Callback {
    void onError(Exception e);
}