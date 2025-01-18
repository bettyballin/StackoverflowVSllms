import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender_2 {
  public static void sendMail(String fromAddress, String password, String toAddress) throws EmailException {
    SimpleEmail email = new SimpleEmail();
    email.setHostName("smtp.gmail.com");
    email.setSmtpPort(587); //465 if using SSL, 587 for TLS
    email.setAuthenticator(new DefaultAuthenticator(fromAddress, password));
    email.setSSLOnConnect(true); // set to false if you're choosing 587 port and sending over TLS/STARTTLS
    //email.setStartTLSEnabled(false);
    email.setFrom(fromAddress);
    email.addTo(toAddress);
    email.setSubject("Test mail using Apache Commons Email");
    email.setMsg("This is a simple test of commons-email.");
    email.send();
  }

  public static void main(String[] args) {
  }
}