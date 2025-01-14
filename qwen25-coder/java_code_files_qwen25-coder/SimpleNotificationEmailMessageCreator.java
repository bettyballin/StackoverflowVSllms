import org.springframework.mail.SimpleMailMessage;

public class SimpleNotificationEmailMessageCreator {
    SimpleMailMessage message;
    String userEmail = "user@example.com";

    public SimpleNotificationEmailMessageCreator() {
        message = new SimpleMailMessage();
        message.setFrom("no-reply@example.com");
        message.setTo(userEmail);
        message.setReplyTo("support@example.com");
        message.setSubject("Notification from ExampleApp");
        message.setText("Your notification content here.");
    }

    public static void main(String[] args) {
        // Instantiate the class
        SimpleNotificationEmailMessageCreator creator = new SimpleNotificationEmailMessageCreator();
    }
}