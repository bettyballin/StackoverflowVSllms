import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mail {
    final String username = "your-username";
    final String password = "your-password";

    public void sendMail() {
        Properties props = new Properties();

        // SMTP server info, for debug purpose the authentication is disabled. You can change its behaviour depending on your needs (either enable it or modify it)
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "localhost"); // use either an IP address or a hostname depending on how hMailServer is configured.
                                                  // In this case we are using the local instance of hMailserver, so it's set to 'localhost'. You likely need to replace 'localhost' with your actual server address.
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", "25"); // Default SMTP port is 25 (for plain communication). For SSL encryption use ports 465/587.
                                           // Ensure the specified port matches to a configured service in hMailServer or otherwise Java will not be able to communicate with it.
        props.put("mail.smtp.socketFactory.port", "25");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username, password);
            }
        });
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email@example.com")); // the sender email address goes here (change as needed)
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sendto-email@example.net"));
            // the recipient's email address(es) go into InternetAddress.parse() (you can add more recipients if desired separated by commas).
            message.setSubject("Testing Subject");  // the subject of your email goes here
            message.setText("Hello, Testing Java mail!");//The text you want to send as body goes here

            Transport transport = session.getTransport("smtp");
            System.out.println( "Sending... ");
            try {
                // use your username and password that are configured for hMailServer (note: the same credentials used when logging into the web administration panel of your hMailserver instance)
                transport.connect("localhost", username, password); // change 'localhost' if needed to match with the server address where your hmailserver is installed.
                transport.sendMessage(message, InternetAddress.parse( "sendto-email@example.net"));// send message here
            } catch (Exception ex) {
                System.out.println("Sending Failed"); // failure exception goes here
            } finally {
                if (transport != null) try { transport.close();} catch( MessagingException e ) {}
            }
        } catch(MessagingException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.sendMail();
    }
}