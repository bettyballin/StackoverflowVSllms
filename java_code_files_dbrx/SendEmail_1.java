import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail_1 {
  public static void main(String[] args) {
    String to = "someone@example.com";
    String from = "me@example.com";
    final String username = "me@example.com"; // Assuming username is the same as 'from'
    final String password = "mypassword";
    String host = "smtp.gmail.com";

    Properties properties = new Properties();

    // Setup mail server
    properties.setProperty("mail.smtp.host", host);
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.debug", "true");
    properties.put("mail.smtp.port", "587"); // TLS
    properties.put("mail.smtp.starttls.enable", "true");
    properties.setProperty("mail.transport.protocol", "smtp");

    // Get the Session object with authentication
    Authenticator authenticator = new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
      }
    };

    Session session = Session.getInstance(properties, authenticator);

    try {
      // Create a default MimeMessage object.
      MimeMessage msg = new MimeMessage(session);

      // Set From: header field of the header.
      msg.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

      // Set Subject: header field
      msg.setSubject("Hello");

      // Now set the actual message
      msg.setText("This is a test email.");

      // Send message
      Transport.send(msg);
      System.out.println("Message sent successfully....");
    } catch (MessagingException mex) {
      mex.printStackTrace();
    }
  }
}