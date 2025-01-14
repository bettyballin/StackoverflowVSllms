import java.util.Properties;
import java.io.File;
import java.io.IOException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class PictureSMSSender {

    public void sendPictureSMS(String recipient, String imagePath) {
        // Create properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com");  // Replace with your SMTP gateway
        props.put("mail.smtp.port", "587");

        // Get the Session object and set mail server properties/authentication
        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("username", "password");  // Replace with your credentials
                }
            });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress("sender@example.com"));  // Replace with sender email

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));

            // Set Subject: header field
            message.setSubject("Picture SMS");

            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();

            // Part one is text
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Please see the attached image.");

            // Second part is attachment
            MimeBodyPart attachPart = new MimeBodyPart();
            File file = new File(imagePath);
            attachPart.attachFile(file);
            attachPart.setFileName(file.getName());

            // Add parts to multipart object.
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachPart);

            // Set the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PictureSMSSender sender = new PictureSMSSender();
        sender.sendPictureSMS("recipient_number@mms-gateway.com", "path/to/your/image.jpg");
    }
}