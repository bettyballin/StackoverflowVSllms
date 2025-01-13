import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetHeaders;
import javax.mail.Session;

public class Main_603 {
    public static void main(String[] args) throws Exception {
        // Create a new Session to avoid NullPointerException
        Session session = Session.getDefaultInstance(System.getProperties(), null);

        // Assuming you have a MimeMessage object named bouncedEmail
        MimeMessage bouncedEmail = new MimeMessage(session); // Initialize with a session

        // Get the headers from the bounced email
        InternetHeaders headers = new InternetHeaders(bouncedEmail.getInputStream());

        // Get the unique ID from the headers
        String uniqueId = headers.getHeader("X-Unique-ID", "");

        // Print the unique ID
        System.out.println(uniqueId);
    }
}