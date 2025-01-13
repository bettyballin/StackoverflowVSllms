import java.lang.String;
import org.smpp.pdu.Address;
import org.smpp.pdu.SubmitSM;
import org.smpp.pdu.SubmitSMResp;
import org.smpp.session.SMPPSession;

public class SendSms {
    public static void main(String[] args) {
        try {
            // Establish a connection to the GPRS modem
            SMPPSession session = new SMPPSession();
            session.connect("gprs_modem_ip", 2775);

            // Create a new SMS message
            SubmitSM submitSM = new SubmitSM();
            submitSM.setDestAddress(new Address((byte) 1, (byte) 1, "recipient_phone_number"));
            submitSM.setSourceAddress(new Address((byte) 1, (byte) 1, "sender_phone_number"));
            submitSM.setShortMessage("Hello, World!");

            // Send the SMS message
            SubmitSMResp response = session.submit(submitSM);

            // Check the response
            if (response.getCommandStatus() == 0) {
                System.out.println("SMS message sent successfully!");
            } else {
                System.out.println("Error sending SMS message: " + response.getCommandStatus());
            }

            // Close the connection
            session.unbindAndClose();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}