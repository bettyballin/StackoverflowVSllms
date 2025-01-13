// Define an interface for the external dependency
public interface EmailService {
    void sendEmail(String recipient, String message);
}

// Implement a concrete email service using Outlook
class OutlookEmailService implements EmailService {
    @Override
    public void sendEmail(String recipient, String message) {
        // Outlook-specific implementation
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

// Use dependency injection to provide the email service
public class MyApplication {
    private EmailService emailService;

    public MyApplication(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmail(String recipient, String message) {
        emailService.sendEmail(recipient, message);
    }

    public static void main(String[] args) {
        EmailService emailService = new OutlookEmailService();
        MyApplication app = new MyApplication(emailService);
        app.sendEmail("example@example.com", "Hello, World!");
    }
}