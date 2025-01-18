import javax.jms.*;
import javax.naming.*;
import java.util.UUID;

public class MailSender {

  // send message via mailSender destination
  public void sendMail(String text, String subject, final Destination dest) throws Exception {
    ConnectionFactory cf = (ConnectionFactory) new InitialContext().lookup("GenericConnectionFactory");

    try (JMSContext context = cf.createContext()) {
      context.setClientID(getNextMessageId()); // Use a unique ID each time message is sent for proper load balancing in JBoss.
      TextMessage msg = context.createTextMessage();
      msg.setText(text);
      msg.setStringProperty("Subject", subject);
      // Add other properties to the email messages as needed.

      final JMSProducer producer = context.createProducer();
      // Asynchronously send an email message
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            producer.send(dest, msg); // Send email asynchronously (this way, your web app will not be blocked).
            context.close();
          } catch (Exception e) {  // Add suitable Exception types here
            e.printStackTrace();
          }
        }
      }).start();

    } catch (Exception e) {  // Handle any unexpected exceptions that occur when sending the mail message.
      e.printStackTrace(System.err);
      throw new MailDeliveryException("Unable to send mails", e);
    }
  }

  private String getNextMessageId() {
    // Implement code to generate unique message IDs
    return UUID.randomUUID().toString();
  }

  public static class MailDeliveryException extends Exception {
    public MailDeliveryException(String message, Throwable cause) {
      super(message, cause);
    }
  }
}