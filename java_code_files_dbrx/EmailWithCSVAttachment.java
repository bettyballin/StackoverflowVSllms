import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.BodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.InternetAddress;
import javax.activation.DataSource;
import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;

public class EmailWithCSVAttachment {

    public static void main(String[] args) {
        try {
            // Set up mail server properties
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.example.com"); // Replace with your SMTP host
            props.put("mail.smtp.port", "587"); // Replace with your SMTP port
            props.put("mail.smtp.auth", "true"); // Enable authentication
            props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

            // Create an authenticator if authentication is needed
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("username", "password"); // Replace with your credentials
                }
            };

            // Get the Session object
            Session session = Session.getInstance(props, auth);

            // Create a new email message
            MimeMessage message = new MimeMessage(session);

            // Set email metadata
            message.setFrom(new InternetAddress("sender@example.com")); // Replace with sender's email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient@example.com")); // Replace with recipient's email
            message.setSubject("Subject of the email");

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This is the body of the email.");

            // Get CSV data as a string
            String csvData = yourMethodToExportTableIntoCSV();  // should return the complete data as string

            // Convert CSV string to input stream
            ByteArrayInputStream in = new ByteArrayInputStream(csvData.getBytes());

            // Create a data source from the input stream
            DataSource ds = new ByteArrayDataSource(in, "text/csv");

            // Create the attachment part
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.setFileName("data.csv");  // filename that you wish to provide with the email
            attachmentPart.setDataHandler(new DataHandler(ds));

            // Create a multipart message
            Multipart multipartContent = new MimeMultipart();
            multipartContent.addBodyPart(messageBodyPart);
            multipartContent.addBodyPart(attachmentPart);

            // Set the complete message parts
            message.setContent(multipartContent);

            // Send the message
            Transport.send(message);  // finally send the email using a Transport provider

            System.out.println("Email sent successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to export table data into CSV format
    public static String yourMethodToExportTableIntoCSV() {
        // Implement your logic here
        // For demonstration, returning sample CSV data
        return "Name,Email,Phone\nJohn Doe,john.doe@example.com,1234567890\nJane Smith,jane.smith@example.com,0987654321";
    }
}