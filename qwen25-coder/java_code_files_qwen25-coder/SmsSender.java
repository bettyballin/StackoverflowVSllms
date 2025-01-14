// Example of sending an SMS using Plivo in Java
import com.plivo.api.Plivo;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;

public class SmsSender {
    private static final String AUTH_ID = "your_auth_id";
    private static final String AUTH_TOKEN = "your_auth_token";

    public static void main(String[] args) throws Exception {
        Plivo.init(AUTH_ID, AUTH_TOKEN);

        MessageCreateResponse response = Message.creator(
                "0987654321",  // From number
                "1234567890",  // To Number
                "Hello from Plivo!"
        ).create();

        System.out.println(response.getId());
    }
}