import java.lang.String;
// Example of a user-friendly method in an API
public class SimpleAPI {
    // High-level method for common tasks
    public void sendEmail(String recipient, String message) throws Exception {
        Email email = new Email();
        email.setTo(recipient);
        email.setBody(message);
        deliver(email);
    }

    // Utility method hidden from most users but accessible when needed
    private void deliver(Email email) throws Exception {
        // Implementation details...
    }

    public static void main(String[] args) {
    }
}

class Email {
    public void setTo(String recipient) {
        // Implementation...
    }

    public void setBody(String message) {
        // Implementation...
    }
}