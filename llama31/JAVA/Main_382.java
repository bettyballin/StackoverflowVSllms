import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Main_382 {
    public static void main(String[] args) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("your-smtp-host");
        email.setSmtpPort(Integer.parseInt("your-smtp-port")); // port should be an integer
        email.setFrom("your-from-email");
        email.setSubject("Your email subject");
        email.setMsg("Your email body");

        String[] yourRecipientsArray = {"recipient1@example.com", "recipient2@example.com"};
        email.addTo(yourRecipientsArray);

        EmailQueue queue = new EmailQueue();
        queue.addEmail(email);
        queue.send();
    }
}

class EmailQueue {
    private Email email;

    public void addEmail(Email email) {
        this.email = email;
    }
    
    public void send() throws EmailException {
        email.send();
    }
}