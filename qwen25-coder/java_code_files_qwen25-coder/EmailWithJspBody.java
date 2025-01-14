import javax.mail.*;
import javax.mail.internet.*;
import java.io.StringWriter;
import java.util.Properties;

public class EmailWithJspBody {

    public void sendEmail() {
        String host = "smtp.yourserver.com";  // SMTP Host address
        String toRecipient = "recipient@example.com";
        String fromSender = "from@example.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);

        Session session = Session.getInstance(properties, null);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromSender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toRecipient));

            // Assuming you have a method to execute JSP and get its output
            String emailBody = executeJspAndCaptureOutput();

            // Set the content of the message
            message.setContent(emailBody, "text/html");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String executeJspAndCaptureOutput() {
        StringWriter stringWriter = new StringWriter();
        try {
            // Here you need to simulate request and response objects
            // and pass them to the JSP page execution.
            // This part is simplified for demonstration and assumes
            // you have a way to execute a JSP and get its output as a String.

            // In practice, you might use a RequestDispatcher or similar mechanism
            // depending on your servlet container to get the rendered HTML from the JSP page.

            stringWriter.write("<html><body>");
            stringWriter.write("<table border='1'><tr><th>Name</th><th>Email</th></tr>");
            stringWriter.write("<tr><td>John Doe</td><td>johndoe@example.com</td></tr>");
            stringWriter.write("</table>");
            stringWriter.write("</body></html>");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    public static void main(String[] args) {
        new EmailWithJspBody().sendEmail();
    }
}