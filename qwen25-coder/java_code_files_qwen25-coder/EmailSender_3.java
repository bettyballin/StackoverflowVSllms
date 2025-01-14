import java.lang.String;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EmailSender_3 implements Runnable {
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void addToQueue(String recipient) {
        try {
            queue.put(recipient);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        while (true) {
            String recipients;
            try {
                recipients = queue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            sendEmail(recipients);
        }
    }

    private void sendEmail(String recipient) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("username@example.com", "password");
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@example.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(recipient));
            message.setSubject("Tutorial Uploaded!");
            message.setText("A new tutorial has been uploaded on our site!");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        EmailSender_3 sender = new EmailSender_3();
        Thread emailThread = new Thread(sender);
        emailThread.start();

        // Add recipients to queue
        sender.addToQueue("user1@example.com");
        sender.addToQueue("user2@example.com");

        try {
            emailThread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}