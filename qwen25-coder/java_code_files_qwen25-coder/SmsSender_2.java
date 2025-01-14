import java.lang.String;
// Example of sending an SMS using Twilio in Java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender_2 {
    // Find your Account SID and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "your_account_sid";
    public static final String AUTH_TOKEN = "your_auth_token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber("+1234567890"),  // To number
                new PhoneNumber("+0987654321"),  // From number
                "Hello from Twilio!")
            .create();

        System.out.println(message.getSid());
    }
}