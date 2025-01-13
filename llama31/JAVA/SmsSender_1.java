import java.lang.String;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;

public class SmsSender_1_1 {
    public static void main(String[] args) {
        String accountSid = "your_account_sid";
        String authToken = "your_auth_token";
        String fromNumber = "+1234567890";
        String toNumber = "+9876543210";
        String messageBody = "Hello from the website!";

        com.twilio.rest.Twilio.init(accountSid, authToken);
        MessageCreator creator = new MessageCreator(
                new PhoneNumber(toNumber),
                new PhoneNumber(fromNumber),
                messageBody
        );

        Message message = creator.create();
        System.out.println("Message sent: " + message.getSid());
    }
}