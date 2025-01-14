import java.lang.String;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender_4 {
    // Find your Account SID and Auth Token at twilio.com/console
    private static final String ACCOUNT_SID = "your_account_sid";
    private static final String AUTH_TOKEN = "your_auth_token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber("+1234567890"),   // to
                new PhoneNumber("+0987654321"),  // from
                "Hello from your Java app!")
            .create();

        System.out.println(message.getSid());
    }
}