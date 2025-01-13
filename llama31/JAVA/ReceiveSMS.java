import com.twilio.rest.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;

public class ReceiveSMS {
    public static void main(String[] args) {
        // Your Twilio account credentials
        String accountSid = "your_account_sid";
        String authToken = "your_auth_token";
        String twilioPhoneNumber = "+1234567890";

        // Create a Twilio client
        Twilio.init(accountSid, authToken);

        // Create a message creator
        MessageCreator messageCreator = new MessageCreator(
                new PhoneNumber(twilioPhoneNumber),
                new PhoneNumber("+9876543210"), // sender's phone number
                "Hello from Twilio!"
        );

        // Receive the message
        Message message = messageCreator.create();

        System.out.println("Received message: " + message.getBody());
    }
}