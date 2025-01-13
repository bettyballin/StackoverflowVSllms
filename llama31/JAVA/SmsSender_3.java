import java.lang.String;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsClient;
import com.nexmo.client.sms.SmsSubmissionMessage;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;

public class SmsSender_3_3 {
  public static void main(String[] args) {
    // Your API Key from nexmo.com
    String apiKey = "your_api_key";
    // Your API Secret from nexmo.com
    String apiSecret = "your_api_secret";
    // The phone number you want to send to
    String toNumber = "+9876543210";
    // The message you want to send
    String message = "Hello from Java!";

    NexmoClient client = new NexmoClient(
      new TokenAuthMethod(apiKey, apiSecret)
    );

    try {
      SmsClient smsClient = client.getSmsClient();
      SmsSubmissionResponse response = smsClient.submitMessage(
        new SmsSubmissionMessage(
          "FROM_NUMBER", // Your virtual phone number
          toNumber,
          message
        )
      );
      System.out.println("SMS sent!");
    } catch (Exception e) {
      System.out.println("Error sending SMS: " + e.getMessage());
    }
  }
}