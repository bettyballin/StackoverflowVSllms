import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.bind.DatatypeConverter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class EmbedImageInEmail {
    public static void main(String[] args) throws Exception {
        // Create a mail session
        Properties props = new Properties();
        props.put("mail.smtp.host", "your_smtp_host"); // e.g. "smtp.gmail.com"
        props.put("mail.smtp.port", "your_smtp_port"); // e.g. "587"
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "your_smtp_host"); // e.g. "smtp.gmail.com"

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("your_email", "your_password");
            }
        });

        // Create a message
        MimeMessage msg = new MimeMessage(session);
        msg.setSubject("Embedded Image Test");
        msg.setFrom(new InternetAddress("from@example.com"));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("to@example.com"));

        // Convert image to base64-encoded string
        byte[] imageData = Files.readAllBytes(Paths.get("logo.png"));
        String base64Image = DatatypeConverter.printBase64Binary(imageData);

        // Create an attachment with a unique Content-ID
        MimeBodyPart attachment = new MimeBodyPart();
        attachment.setFileName("logo.png");
        attachment.setHeader("Content-ID", "<logo@cid>");
        attachment.setDisposition(MimeBodyPart.INLINE);
        attachment.setContent(base64Image, "image/png");

        // Create the HTML body
        MimeBodyPart htmlBody = new MimeBodyPart();
        htmlBody.setContent(
                "<html><body><img src='cid:logo@cid' alt='Company Logo'></body></html>",
                "text/html");

        // Add the attachment and HTML body to the message
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(attachment);
        multipart.addBodyPart(htmlBody);
        msg.setContent(multipart);

        // Send the message
        Transport.send(msg);
    }
}