// Example of sending an SMS using Nexmo in Java
import com.vonage.client.VonageClient;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.SmsSubmissionResponseMessage;
import com.vonage.client.sms.messages.TextMessage;

public class SmsSender_1 {
    private static final String API_KEY = "your_api_key";
    private static final String API_SECRET = "your_api_secret";

    public static void main(String[] args) throws Exception {
        VonageClient client = new VonageClient.Builder()
            .apiKey(API_KEY)
            .apiSecret(API_SECRET)
            .build();

        TextMessage message = new TextMessage(
                "1234567890",
                "0987654321",
                "Hello from Nexmo!");

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
            System.out.println(responseMessage.getMessageId());
        }
    }
}