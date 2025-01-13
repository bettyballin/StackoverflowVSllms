import java.lang.String;
import com.messagebird.MessageBirdClient;
import com.messagebird.MessageBirdService;
import com.messagebird.exceptions.GeneralException;

public class SmsSender_2_2 {
  public static void main(String[] args) {
    // Your API Key from messagebird.com
    String apiKey = "your_api_key";
    // The phone number you want to send to
    String toNumber = "+9876543210";
    // The message you want to send
    String message = "Hello from Java!";

    MessageBirdClient client = new MessageBirdClient(apiKey);
    MessageBirdService service = new MessageBirdService(client);

    try {
      service.sendMessage(
        "FROM_NUMBER", // Your virtual phone number
        toNumber,
        message
      );
      System.out.println("SMS sent!");
    } catch (GeneralException e) {
      System.out.println("Error sending SMS: " + e.getMessage());
    }
  }
}