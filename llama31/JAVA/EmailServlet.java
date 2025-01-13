import java.io.*;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part; // Added import for Part

public class EmailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set up mail server parameters
        String host = "smtp.gmail.com";
        String port = "587";
        String from = "your-email@gmail.com";
        String pass = "your-password";

        // Get the file and email address from the form
        String email = request.getParameter("email");
        Part filePart = request.getPart("file");

        // Send the email with attachment
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, pass);
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("File Upload");
            message.setText("Please find the attached file.");

            // Add the attachment
            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.attachFile(filePart.getInputStream(), filePart.getSubmittedFileName());
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport.send(message);
            response.getWriter().println("Email sent successfully!");
        } catch (Exception e) {
            response.getWriter().println("Error sending email: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // This is a placeholder to technically make this a standalone Java application.
        // However, the functionality within doPost won't be executed without a servlet container.
        System.out.println("This is a servlet and needs to be run from a servlet container.");
    }
}