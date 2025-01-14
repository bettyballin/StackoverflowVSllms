// Example: Sending an SMS using Twilio in Java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender_3 {
    public static final String ACCOUNT_SID = "YOUR_ACCOUNT_SID";
    public static final String AUTH_TOKEN  = "YOUR_AUTH_TOKEN";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(new PhoneNumber("+1234567890"),
                            new PhoneNumber("+0987654321"),
                            "Your message here")
                .create();
    }
}