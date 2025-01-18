import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {
    private static final String ACCOUNT_SID = "ACXXXX"; // Your Twilio account sid
    private static final String AUTH_TOKEN = "YYYYY";   // Your Twilio Auth Token

    public SendSms() {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                new PhoneNumber("+1234567890"), // To number
                new PhoneNumber("+9876543210"), // From number
                "Hello World"                   // SMS body
            ).create();
        } catch (ApiException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
    }
}