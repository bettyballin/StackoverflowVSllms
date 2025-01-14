enum ResultCode {
    OK,
    Fail,
    Fault,
    Exception // For logging purposes only; not recommended to use directly
}

interface Callback {
    void onResult(ResultCode resultCode, Object data);
}

public class SocketClient_1 {

    private static class log {
        public static void error(String message, Throwable t) {
            System.err.println(message);
            t.printStackTrace(System.err);
        }
        public static void error(String message, Object... args) {
            System.err.println(String.format(message.replace("{}", "%s"), args));
        }
    }

    public ResultCode syncCommand(String command) {
        try {
            sendToServer(command);
            String response = receiveFromServer();
            return parseResponse(response); // Maps server's response to OK or Fail
        } catch (Exception e) {
            log.error("Network fault occurred", e);
            return ResultCode.Fault;
        }
    }

    private ResultCode parseResponse(String response) {
        // Logic to convert server's response into ResponseCode, handle Fault only after parsing failure
        if ("OK".equals(response)) {
            return ResultCode.OK;
        } else if ("Fail".equals(response)) {
            return ResultCode.Fail;
        }
        log.error("Unexpected response: {}", response);
        return ResultCode.Fault; // Example of fallback to fault after unexpected response
    }

    public void asyncCommand(String command, Callback callback) {
        try {
            sendAsyncToServer(command);
        } catch (Exception e) {
            log.error("Network fault occurred", e);
            callback.onResult(ResultCode.Fault, null); // Pass null or an error object if needed
        }
    }

    private void sendToServer(String command) throws Exception {
        // Simulated send
    }

    private String receiveFromServer() throws Exception {
        // Simulated receive
        return "OK";
    }

    private void sendAsyncToServer(String command) throws Exception {
        // Simulated async send
    }

    public static void main(String[] args) {
    }
}