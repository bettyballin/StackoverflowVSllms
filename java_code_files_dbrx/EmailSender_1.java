import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    private static String smtpServer = null; // This would store the resolved MX server obtained from DNSJava's functionality above.

    public boolean sendEmail(Session session, Message msg) { 
        try {    
            if (smtpServer ==  null || "".equals(smtpServer)) 
                throw new Exception("No SMTP host found for sending email.");

            Transport transport = session.getTransport();
            // Set up the transport properties based on resolved smtp server from dnsjava library           
            Properties props = System.getProperties();
            props.setProperty("mail.smtps.host", smtpServer);                       
            // Open a connection using the chosen SMTP host in props object
            transport.connect(smtpServer + "", null, null);
            // Send our message                         
            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();     
        } catch (Exception mex) { 
            System.out.println("Error" + mex.toString());
            return false;           
        }
        return true;
    }

    // Additional methods or code can be added here if needed

}