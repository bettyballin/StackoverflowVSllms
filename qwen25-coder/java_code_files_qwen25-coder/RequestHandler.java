import java.util.Map;

public class RequestHandler {
    public void handleRequest(Map<String, String[]> parameters) {
        String[] actions = parameters.get("action");
        if (actions != null && actions.length > 0) {
            String action = actions[0];
            // Validate and sanitize the input
            if ("goback".equals(action)) {
                performGoBackAction();
            } else {
                throw new IllegalArgumentException("Invalid action specified.");
            }
        } else {
            throw new MissingParameterException("No action parameter found.");
        }
    }

    private void performGoBackAction() {
        // Placeholder for the actual action
    }

    // Custom exception class
    public static class MissingParameterException extends RuntimeException {
        public MissingParameterException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        // Optional: Code to test the handleRequest method
    }
}