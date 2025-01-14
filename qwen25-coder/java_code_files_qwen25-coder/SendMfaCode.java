import java.lang.String;
// Example of sending MFA code via SMS using Twilio
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SendMfaCode {
    public static final String ACCOUNT_SID = "YOUR_ACCOUNT_SID";
    public static final String AUTH_TOKEN  = "YOUR_AUTH_TOKEN";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+1234567890"),
                new com.twilio.type.PhoneNumber("+0987654321"),
                "Your MFA code is: 123456")
            .create();

        System.out.println(message.getSid());
    }
}