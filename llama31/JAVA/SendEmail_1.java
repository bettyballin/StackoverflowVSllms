// Import SendGrid library classes
import com.sendgrid.*;
import com.sendgrid.mail.Mail;
import com.sendgrid.mail.MailQueue;

public class SendEmail_1 {
    public static void main(String[] args) {
        // Initialize SendGrid object with your API key
        SendGrid sendgrid = new SendGrid("your-sendgrid-api-key");

        // Create a new Mail object
        Mail mail = new Mail();
        mail.setFrom("your-from-email");
        mail.setSubject("Your email subject");
        mail.setText("Your email body");

        // Assuming yourRecipientsArray is a String array of recipient emails
        String[] yourRecipientsArray = {"recipient1@example.com", "recipient2@example.com"};
        mail.addRecipients(yourRecipientsArray);

        // Create a new MailQueue object with the SendGrid object
        MailQueue queue = new MailQueue(sendgrid);
        queue.add(mail);
        queue.send();
    }
}