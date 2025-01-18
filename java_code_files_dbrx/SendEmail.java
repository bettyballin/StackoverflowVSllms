import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.example.com");
        // Change to match your protocol and port as configured in server
        props.put("mail.smtp.auth", "true"); // Enable authentication
        props.put("mail.smtp.port", "587");  // Set the SMTP Port
        props.put("mail.smtp.timeout", "1000"); // Set Timeout interval
        // Security Options Start here
        props.setProperty("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
        props.put("mail.debug", "true"); // Enable Debug logging

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("myusername@example.com", "mypassword"); // Use your actual username and password
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("senders_emailaddress")); // Change to sender's email address
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("receivers_emailaddress")); // Change to receiver's email address
            msg.setSubject("Subject of the email");
            msg.setText("This is the body of the email");
            msg.saveChanges();

            Transport transport = session.getTransport("smtp"); // Get SMTP Transport
            try {
                transport.connect(); // Connect to SMTP Server
                try {
                    transport.sendMessage(msg, msg.getAllRecipients()); // Send email
                } catch (MessagingException e) {
                    // Handle sending errors
                } finally {
                    try {
                        transport.close();
                    } catch (MessagingException ex) {
                        // Handle exception
                    }
                }
            } finally {
                if (transport != null) {
                    try {
                        transport.close();
                    } catch (Exception ex) {
                        // Handle Transport close Exception
                    }
                }
            }
        } catch (MessagingException mex) {
            mex.printStackTrace(); // Handle connection errors
        }
    }
}