import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender {
    public static void main(String[] args) {
        String[] recipients = {"receiver@gmail.com"};

        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("sender@gmail.com", "mypasswd"));
        email.setSSLOnConnect(true); // Enable SSL

        try {
            for (String recipient : recipients) {
                email.addTo(recipient);
            }
            email.setFrom("sender@gmail.com", "Me");
            email.setSubject("Test message");
            email.setMsg("This is a simple test of commons-email");
            email.send();
            System.out.println("Email sent successfully!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}